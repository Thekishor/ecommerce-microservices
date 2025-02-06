package com.orderservice.service;

import com.orderservice.dto.OrderLineRequest;
import com.orderservice.dto.OrderLineResponse;

import java.util.List;

public interface OrderLineService {

    void saveOrderLine(OrderLineRequest orderLineRequest);

    List<OrderLineResponse> findAllByOrderId(Integer orderId);
}

