package com.paymentservice.service;

import com.paymentservice.dto.PaymentRequest;

public interface PaymentService {

    void createPayment(PaymentRequest paymentRequest);
}
