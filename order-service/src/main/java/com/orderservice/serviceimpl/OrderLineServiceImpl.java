package com.orderservice.serviceimpl;

import com.orderservice.dto.OrderLineRequest;
import com.orderservice.dto.OrderLineResponse;
import com.orderservice.entity.OrderLine;
import com.orderservice.repository.OrderLineRepository;
import com.orderservice.service.OrderLineService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {

    private final OrderLineRepository orderLineRepository;

    private final ModelMapper modelMapper;

    @Override
    public void saveOrderLine(OrderLineRequest orderLineRequest) {
        var order = modelMapper.map(orderLineRequest, OrderLine.class);
        orderLineRepository.save(order);
    }

    @Override
    public List<OrderLineResponse> findAllByOrderId(Integer orderId) {
        return orderLineRepository
                .findAllByOrderId(orderId)
                .stream()
                .map(orderLine -> modelMapper.map(orderLine, OrderLineResponse.class))
                .toList();
    }
}
