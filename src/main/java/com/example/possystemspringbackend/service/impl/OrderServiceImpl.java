package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.customStatusCode.ErrorStatus;
import com.example.possystemspringbackend.dto.OrderStatus;
import com.example.possystemspringbackend.dto.impl.OrderDTO;
import com.example.possystemspringbackend.dto.impl.OrderDetailDTO;
import com.example.possystemspringbackend.entity.impl.OrderEntity;
import com.example.possystemspringbackend.exception.CustomerNotFoundException;
import com.example.possystemspringbackend.exception.DataPersistException;
import com.example.possystemspringbackend.repository.OrderRepository;
import com.example.possystemspringbackend.service.OrderDetailService;
import com.example.possystemspringbackend.service.OrderService;
import com.example.possystemspringbackend.util.AppUtil;
import com.example.possystemspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private Mapping mapping;
    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    public void saveOrder(OrderDTO orderDTO) {
        OrderEntity order = orderRepository.save(mapping.toOrderEntity(orderDTO));
        if (order==null){
            throw new DataPersistException("Order Note Saved");
        }else {
            for (OrderDetailDTO orderDetailDTO:orderDTO.getOrderDetailDTO()){
                orderDetailDTO.setId(AppUtil.generateOrderDetailId());
                orderDetailDTO.setOrder(orderDTO);
                orderDetailService.saveOrderDetail(new OrderDetailDTO(
                        orderDetailDTO.getId(),
                        orderDetailDTO.getDate(),
                        orderDetailDTO.getCustomerId(),
                        orderDetailDTO.getCustomerName(),
                        orderDetailDTO.getCustomerCity(),
                        orderDetailDTO.getCustomerTel(),
                        orderDetailDTO.getItemName(),
                        orderDetailDTO.getOrderQTY(),
                        orderDetailDTO.getUnitPrice(),
                        orderDetailDTO.getItem(),
                        orderDetailDTO.getOrder()
                ));
            }
        }
    }

    @Override
    public void updateOrder(String orderId, OrderDTO orderDTO) {
        Optional<OrderEntity> tmpOrder = orderRepository.findById(orderId);
        if (tmpOrder.isPresent()){
            tmpOrder.get().setDate(orderDTO.getDate());
            tmpOrder.get().setDiscountRate(orderDTO.getDiscountRate());
            tmpOrder.get().setDiscount(orderDTO.getDiscount());
            tmpOrder.get().setSubTotal(orderDTO.getSubTotal());
            tmpOrder.get().setBalance(orderDTO.getBalance());
            tmpOrder.get().setCustomer(mapping.toCustomerEntity(orderDTO.getCustomerId()));
            tmpOrder.get().setOrderDetailsList(mapping.toOrderEntityList(orderDTO.getOrderDetailDTO()));
        }
    }

    @Override
    public void deleteOrder(String orderId) {
        Optional<OrderEntity> tmpOrder = orderRepository.findById(orderId);
        if (!tmpOrder.isPresent()){
            throw new CustomerNotFoundException("OrderId with " + orderId + "Not Found!");
        }else {
            orderRepository.deleteById(orderId);
        }
    }

    @Override
    public OrderStatus getOrder(String orderId) {
        if (orderRepository.existsById(orderId)){
            return mapping.toOrderDTO(orderRepository.getReferenceById(orderId));
        }else {
            return new ErrorStatus(2,"Selected order not found");
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() {
        return mapping.toOrderList(orderRepository.findAll());
    }
}

