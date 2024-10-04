package com.example.possystemspringbackend.service;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.dto.impl.OrderDTO;
import com.example.possystemspringbackend.dto.impl.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    void saveOrder(OrderDetailDTO orderDetailDTO);
    void updateOrder(String orderDetailId, OrderDetailDTO orderDetailDTO);
    void deleteOrder(String orderDetailId);
    CustomerDTO getOrder(String orderDetailId);
    List<OrderDTO> getAllOrder();
}
