package com.example.possystemspringbackend.service;

import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.impl.ItemDTO;
import com.example.possystemspringbackend.dto.impl.OrderDetailDTO;

import java.util.List;

public interface OrderDetailService {
    void saveOrderDetail(OrderDetailDTO orderDetailDTO);
    void updateOrderDetail(String itemId,OrderDetailDTO orderDetailDTO);
    void deleteOrderDetail(String orderDetailId);
    ItemStatus getOrderDetail(String orderDetailId);
    List<ItemDTO> getAllOrderDetail();
}
