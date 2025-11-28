package com.example.AtividadeRMQ.service;

import com.example.AtividadeRMQ.entity.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @RabbitListener(queues = "ordersViniciusEduardo")
    public void listenerPedidos(OrderCreatedEvent evento){
        System.out.println("[NOTIFICAÇÃO] Pedido "
                +evento.getOrderId() + " do cliente " +
                evento.getCustomerName() +
                "(R$ "+ evento.getAmount() + ") " +
                "recebido - notificação enviada.");
    }
}
