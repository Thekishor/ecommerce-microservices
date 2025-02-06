package com.productservice.controller;

import com.productservice.dto.ProductRequest;
import com.productservice.dto.ProductResponse;
import com.productservice.dto.PurchaseRequest;
import com.productservice.dto.PurchaseResponse;
import com.productservice.payload.ApiResponse;
import com.productservice.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product/")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return new ResponseEntity<>("Product created successfully", HttpStatus.CREATED);
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<PurchaseResponse>> purchaseProducts(
            @Valid @RequestBody List<PurchaseRequest> productPurchaseRequests) {
        List<PurchaseResponse> productPurchaseResponses = productService
                .purchaseProducts(productPurchaseRequests);
        return new ResponseEntity<>(productPurchaseResponses, HttpStatus.OK);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("productId") Integer id){
        ProductResponse productResponse = productService.getProductById(id);
        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProduct(){
        List<ProductResponse> productResponses = productService.getAllProduct();
        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") Integer id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(new ApiResponse("Product deleted successfully", true), HttpStatus.OK);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<?> updateProduct(@PathVariable("productId") Integer id , @Valid @RequestBody ProductRequest productRequest){
        productService.updateProduct(id,productRequest);
        return new ResponseEntity<>("Product update successfully", HttpStatus.OK);
    }
}
