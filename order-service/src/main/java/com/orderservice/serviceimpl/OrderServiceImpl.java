package com.orderservice.serviceimpl;

import com.orderservice.dto.*;
import com.orderservice.entity.Order;
import com.orderservice.exception.CustomerNotFoundException;
import com.orderservice.exception.ResourceNotFoundException;
import com.orderservice.feignclient.CustomerClient;
import com.orderservice.feignclient.PaymentClient;
import com.orderservice.kafka.OrderEvent;
import com.orderservice.kafka.OrderProducer;
import com.orderservice.repository.OrderRepository;
import com.orderservice.service.OrderLineService;
import com.orderservice.service.OrderService;
import com.orderservice.webclient.ProductClient;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    private final ModelMapper modelMapper;

    private final ProductClient productClient;

    private final CustomerClient customerClient;

    private final OrderLineService orderLineService;

    private final PaymentClient paymentClient;

    private final OrderProducer orderProducer;

    @Override
    public Integer createOrder(OrderRequest orderRequest) {
        var customer = customerClient.findCustomerById(orderRequest.getCustomerId())
                .orElseThrow(()-> new CustomerNotFoundException("Cannot create order:: No customer exists with the provided Id"));

        var purchaseProduct = productClient.purchaseResponses(orderRequest.getPurchaseRequests());

        var order = orderRepository.save(modelMapper.map(orderRequest, Order.class));

        for (PurchaseRequest purchaseRequest : orderRequest.getPurchaseRequests()){
            orderLineService.saveOrderLine(
                    new OrderLineRequest(
                            null,
                            order.getId(),
                            purchaseRequest.getProductId(),
                            purchaseRequest.getQuantity()
                    )
            );
        }
        var paymentRequest = new PaymentRequest(
                orderRequest.getAmount(),
                orderRequest.getPaymentMethod(),
                order.getId(),
                order.getReference(),
                customer
        );
        paymentClient.requestOrderPayment(paymentRequest);

        orderProducer.sendMessage(new OrderEvent(
                orderRequest.getReference(),
                orderRequest.getAmount(),
                orderRequest.getPaymentMethod(),
                customer,
                purchaseProduct
        ));
        return order.getId();
    }

    @Override
    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> modelMapper.map(order, OrderResponse.class)).toList();
    }

    @Override
    public OrderResponse getOrderById(Integer orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(()-> new ResourceNotFoundException("Order","orderId",orderId));
        return modelMapper.map(order, OrderResponse.class);
    }
}