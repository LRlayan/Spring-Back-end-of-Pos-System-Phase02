package com.example.possystemspringbackend.entity.impl;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderDetails")
public class OrderDetailsEntity {
    @Id
    private String id;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private String customerCity;
    private String customerTel;
    private String itemName;
    private int orderQTY;
    private double unitPrice;
    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "itemCode",referencedColumnName = "itemCode",nullable = false)
    private ItemEntity item;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderID",nullable = false)
    private OrderEntity order;
}
