package com.orderservice.service;

import com.orderservice.dto.OrderRequest;
import com.orderservice.dto.OrderResponse;

import java.util.List;

public interface OrderService {

    Integer createOrder(OrderRequest orderRequest);

    List<OrderResponse> getAllOrders();

    OrderResponse getOrderById(Integer orderId);
}
