package com.example.possystemspringbackend.dto.impl;

import com.example.possystemspringbackend.dto.OrderStatus;
import com.example.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDTO implements SuperDTO, OrderStatus {
    private String orderID;
    private String date;
    private double discountRate;
    private double discount;
    private double subTotal;
    private double balance;
    private CustomerDTO customerId;
    private List<OrderDetailDTO> orderDetailDTO;
}
