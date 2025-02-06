package com.paymentservice.dto;

import com.paymentservice.constant.PaymentMethod;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PaymentRequest {

    private Integer id;
    @NotNull(message = "Amount cannot be null")
    private Long amount;

    @NotNull(message = "Payment method cannot be null")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Order ID cannot be null")
    @Positive(message = "Order ID must be positive")
    private Integer orderId;

    @NotEmpty(message = "Order reference cannot be empty")
    private String orderReference;

    @NotNull(message = "Customer cannot be null")
    private Customer customer;
}
