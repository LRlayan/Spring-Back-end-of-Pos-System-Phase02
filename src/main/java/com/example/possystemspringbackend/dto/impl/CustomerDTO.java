package com.example.possystemspringbackend.dto.impl;

import com.example.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerDTO implements SuperDTO {
    private String customerId;
    private String name;
    private String city;
    private String tel;
}
