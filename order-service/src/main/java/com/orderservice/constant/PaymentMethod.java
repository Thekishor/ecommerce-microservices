package com.orderservice.constant;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public enum PaymentMethod {

    PAYPAL,
    CREDIT_CARD,
    VISA,
    MASTER_CARD,
    BITCOIN
}