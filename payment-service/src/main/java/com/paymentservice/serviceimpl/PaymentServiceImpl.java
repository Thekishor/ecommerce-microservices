package com.paymentservice.serviceimpl;

import com.paymentservice.kafka.PaymentNotification;
import com.paymentservice.dto.PaymentRequest;
import com.paymentservice.entity.Payment;
import com.paymentservice.repository.PaymentRepository;
import com.paymentservice.kafka.NotificationProducer;
import com.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    private final ModelMapper modelMapper;

    private final NotificationProducer notificationProducer;

    @Override
    public void createPayment(PaymentRequest paymentRequest) {
        var payment = paymentRepository.save(modelMapper.map(paymentRequest, Payment.class));
        notificationProducer.sendNotification(
                new PaymentNotification(
                        paymentRequest.getOrderReference(),
                        paymentRequest.getAmount(),
                        paymentRequest.getPaymentMethod(),
                        paymentRequest.getCustomer().getName(),
                        paymentRequest.getCustomer().getEmail(),
                        paymentRequest.getCustomer().getPassword()
                )
        );
    }
}
