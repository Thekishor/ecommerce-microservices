package com.notificationservice.payment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentConfirmation {

    private String orderReference;

    private Long amount;

    private PaymentMethod paymentMethod;

    private String customerName;

    private String customerEmail;
}
