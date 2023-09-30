package com.example.auth.rabbitmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Value("${sr.rabbit.queue}")
    private String queueName;
    @Value("${sr.rabbit.routing}")
    private String routingName;
    @Value("${sr.rabbit.exchange}")
    private String exchangeName;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Bean
    public Queue queue() {
        return new Queue(queueName);
    }

    @Bean
    DirectExchange directExchange() {
        return new DirectExchange(exchangeName);
    }
    @Bean
    public Binding binding(final Queue queue, final DirectExchange directExchange){
        return BindingBuilder.bind(queue).to(directExchange).with(routingName);
    }
}
