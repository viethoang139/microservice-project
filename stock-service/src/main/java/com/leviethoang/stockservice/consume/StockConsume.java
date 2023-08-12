package com.leviethoang.stockservice.consume;

import com.leviethoang.stockservice.dto.OrderDto;
import com.leviethoang.stockservice.entity.Order;
import com.leviethoang.stockservice.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StockConsume {
    private final ModelMapper modelMapper;
    private final OrderRepository orderRepository;
    private static final Logger LOGGER = LoggerFactory.getLogger(StockConsume.class);

    @RabbitListener(queues = "${spring.queue.name}")
    public void consume(OrderDto orderDto){
        LOGGER.info(String.format("Received message -> %s",orderDto.toString()));
        Order order = modelMapper.map(orderDto, Order.class);
        orderRepository.save(order);
    }
}
