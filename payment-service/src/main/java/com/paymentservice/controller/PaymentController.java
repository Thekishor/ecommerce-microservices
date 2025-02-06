package com.paymentservice.controller;

import com.paymentservice.dto.PaymentRequest;
import com.paymentservice.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payment/")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<?> createPayment(@Valid @RequestBody PaymentRequest paymentRequest){
        paymentService.createPayment(paymentRequest);
        return new ResponseEntity<>("Payment Successfully Created", HttpStatus.CREATED);
    }
}
