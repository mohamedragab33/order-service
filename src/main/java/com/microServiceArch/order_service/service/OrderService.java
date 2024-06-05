package com.microServiceArch.order_service.service;


import com.microServiceArch.order_service.dto.OrderReq;
import com.microServiceArch.order_service.entity.Order;
import com.microServiceArch.order_service.mappers.OrderMapper;
import com.microServiceArch.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public void createOrder (OrderReq orderReq){
        Order order = Order.builder()
                .orderLineItems(orderMapper.toOrderLineItems(orderReq.orderLineItemsReq()))
                .orderNumber(UUID.randomUUID().toString()).build();
        orderRepository.save(order);
        log.info("{} is Created successfully ", order.getOrderNumber());
    }


}
