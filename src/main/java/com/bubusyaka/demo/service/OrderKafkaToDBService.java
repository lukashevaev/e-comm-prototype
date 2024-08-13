package com.bubusyaka.demo.service;

import com.bubusyaka.demo.model.dto.OrderDTO;
import com.bubusyaka.demo.model.entity.OrderEntity;
import com.bubusyaka.demo.repository.jpa.OrderRepository;

import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderKafkaToDBService {

        private final OrderRepository orderRepository;

        private final ModelMapper modelMapper;

        @Autowired
        public OrderKafkaToDBService(OrderRepository orderRepository, ModelMapper modelMapper) {
            this.orderRepository = orderRepository;
            this.modelMapper = modelMapper;
        }

        public void persistOrder(OrderDTO orderDto) {

            OrderEntity order = modelMapper.map(orderDto, OrderEntity.class);
            OrderEntity persistedOrder = orderRepository.save(order);

            log.info("order persisted with id: {}", persistedOrder.getId());
            //log.info("delivery time: {}", persistedOrder.getCompletionDate());
        }

    }

