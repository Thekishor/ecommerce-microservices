package com.productservice.repository;

import com.productservice.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    //retrieve all ids which stores into database according to customer orders or purchase requests
    List<Product> findAllByIdInOrderById(List<Integer> productId);
}
