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

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        CustomerEntity customer = customerRepository.save(mapping.toCustomerEntity(customerDTO));
        if (customer==null){
            throw new DataPersistException("Customer Note Saved");
        }
    }

    @Override
    public void updateCustomer(String customerId, CustomerDTO customerDTO) {
        Optional<CustomerEntity> tmpCustomer = customerRepository.findById(customerId);
        if (tmpCustomer.isPresent()){
            tmpCustomer.get().setName(customerDTO.getName());
            tmpCustomer.get().setCity(customerDTO.getCity());
            tmpCustomer.get().setTel(customerDTO.getTel());
        }
    }

    @Override
    public void deleteCustomer(String customerId) {
        Optional<CustomerEntity> tmpCustomer = customerRepository.findById(customerId);
        if (!tmpCustomer.isPresent()){
            throw new CustomerNotFoundException("Customer ID with " + customerId + "Not Found!");
        }else {
            customerRepository.deleteById(customerId);
        }
    }

    @Override
    public CustomerStatus getCustomer(String customerId) {
        if (customerRepository.existsById(customerId)){
            return mapping.toCustomerDTO(customerRepository.getReferenceById(customerId));
        }else {
            return new ErrorStatus(2,"Selected Customer not found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return mapping.customerList(customerRepository.findAll());
    }
}
