package com.example.possystemspringbackend.dto.impl;

import com.example.possystemspringbackend.dto.CustomerStatus;
import com.example.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO, CustomerStatus {
    private String customerId;
    private String name;
    private String city;
    private String tel;
    private List<OrderDTO> orderList;
}
