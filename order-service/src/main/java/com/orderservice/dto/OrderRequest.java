package com.orderservice.dto;

import com.orderservice.constant.PaymentMethod;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderRequest {

    private Integer id;

    @NotNull(message = "Reference cannot be empty")
    private String reference;

    @Positive(message = "Order totalAmount should be positive")
    private Long amount;

    @NotNull(message = "Payment method should be specified")
    private PaymentMethod paymentMethod;

    @NotNull(message = "Customer should be present")
    @NotEmpty(message = "Customer should be present")
    @NotBlank(message = "Customer should be present")
    private String customerId;

    @NotNull(message = "Purchase requests cannot be null")
    @NotEmpty(message = "You should at least purchase one product")
    private List<@Valid PurchaseRequest> purchaseRequests;
}
