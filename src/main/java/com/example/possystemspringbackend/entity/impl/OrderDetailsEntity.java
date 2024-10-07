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
    private int orderQTY;
    private double unitPrice;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemCode")
    private ItemEntity item;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orderID")
    private OrderEntity order;

//duplicate column mapping
//   Add @Column(insertable = false, updatable = false) to prevent duplicate column mapping
//    @Column(insertable = false, updatable = false)
//    private String itemCode;
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "itemCode",referencedColumnName = "itemCode")
//    private ItemEntity item;
}
