package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.dto.impl.OrderDTO;
import com.example.possystemspringbackend.dto.impl.OrderDetailDTO;
import com.example.possystemspringbackend.service.OrderDetailService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
    @Override
    public void saveOrder(OrderDetailDTO orderDetailDTO) {

    }

    @Override
    public void updateOrder(String orderDetailId, OrderDetailDTO orderDetailDTO) {

    }

    @Override
    public void deleteOrder(String orderDetailId) {

    }

    @Override
    public CustomerDTO getOrder(String orderDetailId) {
        return null;
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        return null;
    }
}
