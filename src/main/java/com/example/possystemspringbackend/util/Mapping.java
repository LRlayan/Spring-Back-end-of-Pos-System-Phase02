package com.example.possystemspringbackend.util;

import com.example.possystemspringbackend.dto.impl.CustomerDTO;
import com.example.possystemspringbackend.entity.impl.CustomerEntity;
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
        return mapper.map(customerDTO,CustomerEntity.class); //map() -  meken karanne userDto ek UserEntity ekakta convert krnwa
    }

    public CustomerDTO toCustomerDTO(CustomerEntity userEntity){
        return mapper.map(userEntity,CustomerDTO.class);
    }

    public List<CustomerDTO> customerList(List<CustomerEntity> customerList) {
        return mapper.map(customerList,new TypeToken<List<CustomerDTO>>(){}.getType());
    }
}
