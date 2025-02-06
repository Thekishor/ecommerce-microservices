package com.orderservice.controller;

import com.orderservice.dto.OrderLineResponse;
import com.orderservice.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines/")
@RequiredArgsConstructor
public class OrderLineController {

    private final OrderLineService orderLineService;

    @GetMapping("/order/{orderId}")
    public ResponseEntity<List<OrderLineResponse>> findByOrderId(@PathVariable("orderId") Integer orderId){
        List<OrderLineResponse> orderLineResponses = orderLineService.findAllByOrderId(orderId);
        return new ResponseEntity<>(orderLineResponses, HttpStatus.OK);
    }
}
