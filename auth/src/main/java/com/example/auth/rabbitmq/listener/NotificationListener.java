package com.example.auth.rabbitmq.listener;

import com.example.auth.rabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {
    @RabbitListener(queues = "GeneralNotificationQueue")
    public void handleMessage(Notification notification){
        System.out.println("Message Received");
        System.out.println(notification.toString());
    }
}
