package com.orderservice.kafka;

import com.orderservice.constant.PaymentMethod;
import com.orderservice.dto.CustomerResponse;
import com.orderservice.dto.PurchaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderEvent {

    private String orderReference;

    private Long amount;

    private PaymentMethod paymentMethod;

    private CustomerResponse customerResponse;

    private List<PurchaseResponse> purchaseResponse;
}
