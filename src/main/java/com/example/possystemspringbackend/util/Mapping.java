package com.example.possystemspringbackend.util;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.dto.impl.ItemDTO;
import com.example.possystemspringbackend.dto.impl.OrderDTO;
import com.example.possystemspringbackend.dto.impl.OrderDetailDTO;
import com.example.possystemspringbackend.entity.impl.CustomerEntity;
import com.example.possystemspringbackend.entity.impl.ItemEntity;
import com.example.possystemspringbackend.entity.impl.OrderDetailsEntity;
import com.example.possystemspringbackend.entity.impl.OrderEntity;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Mapping {
    @Autowired
    private ModelMapper mapper;

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return mapper.map(customerDTO,CustomerEntity.class);
    }

    public CustomerDTO toCustomerDTO(CustomerEntity userEntity){
        return mapper.map(userEntity,CustomerDTO.class);
    }

    public List<CustomerDTO> customerList(List<CustomerEntity> customerList) {
        return mapper.map(customerList,new TypeToken<List<CustomerDTO>>(){}.getType());
    }

    public ItemEntity toItemEntity(ItemDTO itemDTO) {
        return mapper.map(itemDTO,ItemEntity.class);
    }

    public ItemDTO toItemDTO(ItemEntity itemEntity) {
        return mapper.map(itemEntity,ItemDTO.class);
    }

    public List<ItemDTO> toItemList(List<ItemEntity> itemList) {
        return mapper.map(itemList,new TypeToken<List<ItemDTO>>(){}.getType());
    }
    public OrderEntity toOrderEntity(OrderDTO orderDTO) {
        return mapper.map(orderDTO, OrderEntity.class);
    }
    public OrderDTO toOrderDTO(OrderEntity orderEntity){
        return mapper.map(orderEntity,OrderDTO.class);
    }
    public List<OrderDTO> toOrderList(List<OrderEntity> orderList){
        return mapper.map(orderList,new TypeToken<List<OrderDTO>>(){}.getType());
    }
    public List<OrderDetailsEntity> toOrderEntityList(List<OrderDetailDTO> orderList){
        return mapper.map(orderList,new TypeToken<List<OrderDetailsEntity>>(){}.getType());
    }
    public OrderDetailsEntity toOrderDetailEntity(OrderDetailDTO orderDetailDTO) {
        return mapper.map(orderDetailDTO, OrderDetailsEntity.class);
    }
}
