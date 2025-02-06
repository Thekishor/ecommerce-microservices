package com.notificationservice.entity;

import com.notificationservice.constant.NotificationType;
import com.notificationservice.order.OrderConfirmation;
import com.notificationservice.payment.PaymentConfirmation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(value = "notification")
public class Notification {

    private String id;

    private NotificationType notificationType;

    private LocalDateTime localDateTime;

    private OrderConfirmation orderConfirmation;

    private PaymentConfirmation paymentConfirmation;
}
