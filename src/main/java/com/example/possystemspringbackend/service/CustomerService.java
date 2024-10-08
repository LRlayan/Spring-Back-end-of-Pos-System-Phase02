package com.example.possystemspringbackend.service;

import com.example.possystemspringbackend.dto.CustomerStatus;
import com.example.possystemspringbackend.dto.impl.CustomerDTO;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO customerDTO);
    void updateCustomer(String customerId,CustomerDTO customerDTO);
    void deleteCustomer(String customerId);
    CustomerStatus getCustomer(String customerId);
    List<CustomerDTO>getAllCustomer();
}
