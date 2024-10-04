package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.dto.impl.OrderDTO;
import com.example.possystemspringbackend.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Override
    public void saveOrder(OrderDTO orderDTO) {

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

