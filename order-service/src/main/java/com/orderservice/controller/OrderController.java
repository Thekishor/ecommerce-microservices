package com.orderservice.controller;

import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponse;
import com.orderservice.service.OrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/order/")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<?> createOrder(@Valid @RequestBody OrderRequest orderRequest){
        System.out.println(orderRequest);
        try {
            Integer orderId = orderService.createOrder(orderRequest);
            return new ResponseEntity<>("Order Created Successfully :" + orderId, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error processing order: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping
    public ResponseEntity<List<OrderResponse>> findAllOrders(){
        List<OrderResponse> orderResponses = orderService.getAllOrders();
        return new ResponseEntity<>(orderResponses,HttpStatus.OK);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderResponse> getOrderById(@PathVariable("orderId") Integer id){
        OrderResponse orderResponse = orderService.getOrderById(id);
        return new ResponseEntity<>(orderResponse,HttpStatus.OK);
    }
}
