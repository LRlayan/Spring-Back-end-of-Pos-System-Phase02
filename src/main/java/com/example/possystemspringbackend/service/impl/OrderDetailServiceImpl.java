package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.impl.ItemDTO;
import com.example.possystemspringbackend.dto.impl.OrderDetailDTO;
import com.example.possystemspringbackend.repository.OrderDetailRepository;
import com.example.possystemspringbackend.service.OrderDetailService;
import com.example.possystemspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveOrderDetail(OrderDetailDTO orderDetailDTO) {
        orderDetailRepository.save(mapping.toOrderDetailEntity(orderDetailDTO));
    }

    @Override
    public void updateOrderDetail(String itemId, OrderDetailDTO orderDetailDTO) {}

    @Override
    public void deleteOrderDetail(String orderDetailId) {}

    @Override
    public ItemStatus getOrderDetail(String orderDetailId) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllOrderDetail() {
        return null;
    }
}
