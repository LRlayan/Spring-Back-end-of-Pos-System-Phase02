package com.example.possystemspringbackend.service;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;

import java.util.List;

public interface ItemService {
    void saveItem(CustomerDTO customerDTO);
    void updateItem(String customerId,CustomerDTO customerDTO);
    void deleteItem(String customerId);
    CustomerDTO getItem(String customerId);
    List<CustomerDTO> getAllItem();
}
