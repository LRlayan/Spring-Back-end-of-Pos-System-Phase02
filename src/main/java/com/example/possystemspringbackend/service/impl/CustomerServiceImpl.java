package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.customStatusCode.ErrorStatus;
import com.example.possystemspringbackend.dto.CustomerStatus;
import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.entity.impl.CustomerEntity;
import com.example.possystemspringbackend.exception.CustomerNotFoundException;
import com.example.possystemspringbackend.exception.DataPersistException;
import com.example.possystemspringbackend.repository.CustomerRepository;
import com.example.possystemspringbackend.service.CustomerService;
import com.example.possystemspringbackend.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private Mapping mapping;
    static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        logger.info("Attempting to save customer with ID: {}", customerDTO.getCustomerId());
        CustomerEntity customer = customerRepository.save(mapping.toCustomerEntity(customerDTO));
        if (customer==null){
            logger.error("Customer with ID: {} is null", customerDTO.getCustomerId());
            throw new DataPersistException("Customer Note Saved");
        }else {
            logger.info("Customer with ID: {} has been saved successfully", customerDTO.getCustomerId());
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        logger.info("Attempting to update customer with ID: {}", customerId);
        Optional<CustomerEntity> tmpCustomer = customerRepository.findById(customerId);
        if (tmpCustomer.isPresent()){
            tmpCustomer.get().setName(customerDTO.getName());
            tmpCustomer.get().setCity(customerDTO.getCity());
            tmpCustomer.get().setTel(customerDTO.getTel());
            logger.info("Customer with ID: {} has been updated successfully", customerId);
        }else {
            logger.warn("Customer with ID: {} not found for update", customerId);
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        logger.info("Request to delete customer with ID: {}", customerId);
        Optional<CustomerEntity> tmpCustomer = customerRepository.findById(customerId);
        if (!tmpCustomer.isPresent()){
            logger.error("Customer ID {} not found", customerId);
            throw new CustomerNotFoundException("Customer ID with " + customerId + "Not Found!");
        }else {
            customerRepository.deleteById(customerId);
            logger.info("Successfully deleted customer with ID: {}", customerId);
        }
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        logger.info("Request to get customer with ID: {}", customerId);
        if (customerRepository.existsById(customerId)){
            logger.info("Customer with ID {} found", customerId);
            return mapping.toCustomerDTO(customerRepository.getReferenceById(customerId));
        }else {
            logger.warn("Customer with ID {} not found", customerId);
            return new ErrorStatus(2,"Selected Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        logger.info("Request to get all customers");
        List<CustomerDTO> customers = mapping.customerList(customerRepository.findAll());
        if (customers.isEmpty()) {
            logger.warn("No customers found");
        } else {
            logger.info("Number of customers found: {}", customers.size());
        }
        return customers;
    }
}
