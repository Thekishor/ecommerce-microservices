package com.productservice.service;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.dto.PurchaseRequest;
import com.productservice.dto.PurchaseResponse;

import java.util.List;

public interface ProductService {

    void createProduct(ProductRequest productRequest);

    List<PurchaseResponse> purchaseProducts(List<PurchaseRequest> purchaseRequests);

    List<ProductResponse> getAllProduct();

    ProductResponse getProductById(Integer id);

    void deleteProduct(Integer id);

    void updateProduct(Integer id, ProductRequest productRequest);

}
