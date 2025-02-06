package com.productservice.serviceimpl;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.dto.PurchaseRequest;
import com.productservice.dto.PurchaseResponse;
import com.productservice.entity.Product;
import com.productservice.exception.ProductPurchaseException;
import com.productservice.exception.ResourceNotFoundException;
import com.productservice.repository.ProductRepository;
import com.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = modelMapper.map(productRequest, Product.class);
        productRepository.save(product);
    }

    @Override
    public List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> purchaseRequests) {

        // Extracting Product IDs
        var productIds = purchaseRequests.stream().map(PurchaseRequest::getProductId).toList();

        //Fetching Stored Products
        var storedProducts = productRepository.findAllByIdInOrderById(productIds);

        // Checking for Missing Products
        if (productIds.size() != storedProducts.size()){
            throw new ProductPurchaseException("One or more products does not exists");
        }

        //Sorting the Requests
        var storedRequest = purchaseRequests.stream().sorted(Comparator.comparing(PurchaseRequest::getProductId)).toList();

        //Processing Each Product Purchase and Checking Stock Availability
        var purchaseProducts = new ArrayList<PurchaseResponse>();
        for (int i = 0; i < storedProducts.size(); i++) {
            var product = storedProducts.get(i);
            var productRequest = storedRequest.get(i);
            if (product.getQuantity() < productRequest.getQuantity()) {
                throw new ProductPurchaseException(
                        "Insufficient stock quantity for product with ID:: " + productRequest.getProductId());
            }
            var newQuantity = product.getQuantity() - productRequest.getQuantity();
            product.setQuantity(newQuantity);
            productRepository.save(product);
            purchaseProducts.add(modelMapper.map(product, PurchaseResponse.class));
        }
        return purchaseProducts;
    }

    @Override
    public List<ProductResponse> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(product -> modelMapper.map(product, ProductResponse.class)).toList();
    }

    @Override
    public ProductResponse getProductById(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","Id",id));
        return modelMapper.map(product, ProductResponse.class);
    }

    @Override
    public void deleteProduct(Integer id) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","Id",id));
        productRepository.delete(product);
    }

    @Override
    public void updateProduct(Integer id, ProductRequest productRequest) {
        Product product = productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product","Id",id));
        product.setName(productRequest.getName());
        product.setDescription(productRequest.getDescription());
        product.setQuantity(productRequest.getQuantity());
        product.setPrice(productRequest.getPrice());
        productRepository.save(product);
    }
}
