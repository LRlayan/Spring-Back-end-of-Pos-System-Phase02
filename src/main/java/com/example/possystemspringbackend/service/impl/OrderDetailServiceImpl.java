package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.impl.ItemDTO;
import com.example.possystemspringbackend.dto.impl.OrderDetailDTO;
import com.example.possystemspringbackend.entity.impl.OrderDetailsEntity;
import com.example.possystemspringbackend.exception.DataPersistException;
import com.example.possystemspringbackend.repository.OrderDetailRepository;
import com.example.possystemspringbackend.service.OrderDetailService;
import com.example.possystemspringbackend.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    Logger logger = LoggerFactory.getLogger(OrderDetailServiceImpl.class);

    @Override
    public void saveOrderDetail(OrderDetailDTO orderDetailDTO) {
        logger.info("Attempting to save order detail with ID: {}", orderDetailDTO.getId());
        OrderDetailsEntity orderDetailsEntity = orderDetailRepository.save(mapping.toOrderDetailEntity(orderDetailDTO));
        if (orderDetailsEntity==null){
            logger.error("Order detail with ID: {} could not be saved", orderDetailDTO.getId());
            throw new DataPersistException("Order detail not saved");
        } else {
            logger.info("Order detail with ID: {} has been saved successfully", orderDetailDTO.getId());
        }
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
