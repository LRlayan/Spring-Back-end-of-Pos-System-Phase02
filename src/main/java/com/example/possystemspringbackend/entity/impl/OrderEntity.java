package com.example.possystemspringbackend.entity.impl;

import com.example.possystemspringbackend.entity.SuperEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order")
public class OrderEntity implements SuperEntity {
    @Id
    private String id;
    private String orderID;
    private LocalDate date;
    private String cusId;
    private double discountRate;
    private double discount;
    private double subTotal;
    private double balance;
    @ManyToOne
    @JoinColumn(name = "customerId",nullable = false)
    private CustomerEntity customer;
}
