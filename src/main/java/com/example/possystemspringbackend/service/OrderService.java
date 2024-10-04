package com.example.possystemspringbackend.service;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.dto.impl.OrderDTO;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderDTO orderDTO);
    void updateOrder(String orderId,OrderDTO orderDTO);
    void deleteOrder(String orderId);
    OrderDTO getOrder(String orderId);
    List<OrderDTO> getAllOrder();
}
