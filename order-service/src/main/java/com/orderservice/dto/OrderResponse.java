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
public class OrderResponse {

    private Integer id;

    private String reference;

    private Long amount;

    private PaymentMethod paymentMethod;

    private String customerId;
}
