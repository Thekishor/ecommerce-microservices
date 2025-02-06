package com.notificationservice.kafka;

import com.notificationservice.constant.NotificationType;
import com.notificationservice.email.EmailService;
import com.notificationservice.entity.Notification;
import com.notificationservice.order.OrderConfirmation;
import com.notificationservice.payment.PaymentConfirmation;
import com.notificationservice.repository.NotificationRepository;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import static java.lang.String.format;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository notificationRepository;
    private final EmailService emailService;

    @KafkaListener(topics = "payment_topics" , groupId = "paymentId")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info(format("Consuming the message form payment-topic Topic:: %s", paymentConfirmation));
        notificationRepository.save(
                Notification.builder()
                        .notificationType(NotificationType.PAYMENT_CONFIRMATION)
                        .localDateTime(LocalDateTime.now())
                        .paymentConfirmation(paymentConfirmation)
                        .build()
        );

        var customerName = paymentConfirmation.getCustomerName();
        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.getCustomerEmail(),
                customerName,
                paymentConfirmation.getAmount(),
                paymentConfirmation.getOrderReference()
        );
    }

    @KafkaListener(topics = "order_topics" , groupId = "orderId")
    public void consumeOrderSuccessNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info(format("Consuming the message form payment-topic Topic:: %s", orderConfirmation));
        notificationRepository.save(
                Notification.builder()
                        .notificationType(NotificationType.ORDER_CONFIRMATION)
                        .localDateTime(LocalDateTime.now())
                        .orderConfirmation(orderConfirmation)
                        .build()
        );

        var customerName = orderConfirmation.getCustomer().getName();
        emailService.sendOrderConfirmationEmail(
                orderConfirmation.getCustomer().getEmail(),
                customerName,
                orderConfirmation.getAmount(),
                orderConfirmation.getOrderReference(),
                orderConfirmation.getProducts()
        );
    }
}