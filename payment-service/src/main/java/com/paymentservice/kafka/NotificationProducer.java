package com.paymentservice.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducer {

    private final KafkaTemplate<String, PaymentNotification> kafkaTemplate;

    public void sendNotification(PaymentNotification paymentNotification){
        log.info("Sending notification with body <{}>", paymentNotification);
        try {
            Message<PaymentNotification> message = MessageBuilder
                    .withPayload(paymentNotification)
                    .setHeader(KafkaHeaders.TOPIC, "payment_topics")
                    .build();
        } catch (Exception exception){
            log.error("Error sending message: {}", exception.getMessage(), exception);
        }
    }
}
