package com.paymentservice.kafka;

import com.paymentservice.constant.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PaymentNotification {

    private String orderReference;

    private Long amount;

    private PaymentMethod paymentMethod;

    private String customerName;

    private String customerEmail;

    private String customerPassword;
}
