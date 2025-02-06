package com.orderservice.dto;

import com.orderservice.constant.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PaymentRequest {

    private Long amount;

    private PaymentMethod paymentMethod;

    private Integer orderId;

    private String orderReference;

    private CustomerResponse customer;
}
