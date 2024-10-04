package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.service.ItemService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Override
    public void saveItem(CustomerDTO customerDTO) {

    }

    @Override
    public void updateItem(String customerId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteItem(String customerId) {

    }

    @Override
    public CustomerDTO getItem(String customerId) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllItem() {
        return null;
    }
}
