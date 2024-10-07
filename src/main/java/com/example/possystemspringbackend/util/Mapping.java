package com.example.possystemspringbackend.util;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.entity.impl.CustomerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapping {
    @Autowired
    private ModelMapper mapper;

    public CustomerEntity toCustomerEntity(CustomerDTO customerDTO){
        return mapper.map(customerDTO,CustomerEntity.class); //map() -  meken karanne userDto ek UserEntity ekakta convert krnwa
    }

    public CustomerDTO toCustomerDTO(CustomerEntity userentity){
        return mapper.map(userentity,CustomerDTO.class);
    }
}
