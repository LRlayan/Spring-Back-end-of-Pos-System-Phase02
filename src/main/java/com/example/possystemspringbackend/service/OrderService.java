package com.example.possystemspringbackend.service;

import com.example.possystemspringbackend.dto.OrderStatus;
import com.example.possystemspringbackend.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    void updateOrder(String orderId,OrderDTO orderDTO);
    void deleteOrder(String orderId);
    OrderStatus getOrder(String orderId);
    List<OrderDTO> getAllOrder();
}
