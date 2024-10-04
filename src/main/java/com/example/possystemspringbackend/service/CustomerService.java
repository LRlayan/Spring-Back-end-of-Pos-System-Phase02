package com.example.possystemspringbackend.service;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String customerId,CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerDTO getCustomer(String customerId);
    List<CustomerDTO>getAllCustomer();
}
