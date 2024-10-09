package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.dto.impl.OrderDTO;
import com.example.possystemspringbackend.entity.impl.OrderEntity;
import com.example.possystemspringbackend.exception.DataPersistException;
import com.example.possystemspringbackend.repository.OrderRepository;
import com.example.possystemspringbackend.service.OrderService;
import com.example.possystemspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private Mapping mapping;
    @Override
    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity order = orderRepository.save(mapping.toOrderEntity(orderDTO));
        if (order==null){
            throw new DataPersistException("Order Note Saved");
        }
    }

    @Override
    public void updateOrder(String orderId, OrderDTO orderDTO) {

    }

    @Override
    public void deleteOrder(String orderId) {

    }

    @Override
    public OrderDTO getOrder(String orderId) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        return null;
    }
}

