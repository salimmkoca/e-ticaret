package com.example.auth.rabbitmq.producer;

import com.example.auth.rabbitmq.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;
@Service
public class NatificationProducer {
    @Autowired
    RabbitTemplate rabbitTemplate;
    public void createAndSendNotification(String message){
        Notification notification = new Notification();
        notification.setNotificationID(UUID.randomUUID().toString());
        notification.setMessage(message);
        notification.setCreatedAt(new Date());
        sendToQueue(notification);
    }

    public void sendToQueue(Notification notification){
        System.out.println("Notification Sent ID: "+notification.getNotificationID());
        rabbitTemplate.convertAndSend("GeneralExchangeQueue","GeneralRoutingQueue",notification);
    }
}
