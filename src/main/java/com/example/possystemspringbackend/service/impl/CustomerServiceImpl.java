package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.service.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Override
    public void saveCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String customerId) {

    }

    @Override
    public CustomerDTO getCustomer(String customerId) {
        return null;
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return null;
    }
}
