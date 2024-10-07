package com.example.possystemspringbackend.controller;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.exception.DataPersistException;
import com.example.possystemspringbackend.service.CustomerService;
import com.example.possystemspringbackend.util.AppUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public ResponseEntity<Void> saveCustomer(CustomerDTO customerDTO){
        customerDTO.setCustomerId(AppUtil.generateCustomerId());
        try{
            customerService.saveCustomer(customerDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
