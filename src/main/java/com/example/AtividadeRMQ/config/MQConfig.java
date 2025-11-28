package com.example.AtividadeRMQ.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.support.converter.MessageConverter;

@Configuration
public class MQConfig {
    public static final String EXCHANGE_NAME = "orders.exchange";
    public static final String QUEUE_NAME = "ordersViniciusEduardo";
    public static final String ROUTING_KEY = "orders.created";

    @Bean
    public DirectExchange ordersExchange() {
        return new DirectExchange(EXCHANGE_NAME, true, false);
    }

    @Bean
    public Queue ordersCreatedQueue() {
        return new Queue(QUEUE_NAME, true);
    }

    @Bean
    public Binding bindingOrders() {
        return BindingBuilder.bind(ordersCreatedQueue())
                .to(ordersExchange())
                .with(ROUTING_KEY);
    }

    // Converte JSON -> objeto usando Jackson
    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    // Configura o listener container para usar o conversor JSON
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory,
                                         MessageConverter jsonMessageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter);
        return template;
    }
}