package com.leviethoang.orderservice.producer;

import com.leviethoang.orderservice.dto.OrderDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    @Value("${spring.exchange.name}")
    private String exchange;

    @Value("${spring.routing.key.name}")
    private String routingKey;

    private static final Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    private RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderDto orderDto){
        LOGGER.info(String.format("Send message -> %s",orderDto.toString()));
        rabbitTemplate.convertAndSend(exchange,routingKey,orderDto);
    }


}
