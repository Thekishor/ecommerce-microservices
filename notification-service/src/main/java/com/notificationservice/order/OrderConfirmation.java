package com.notificationservice.order;

import com.notificationservice.payment.PaymentMethod;
import com.notificationservice.customer.Customer;
import com.notificationservice.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderConfirmation {

    private String orderReference;

    private Long amount;

    private PaymentMethod paymentMethod;

    private Customer customer;

    private List<Product> products;
}
