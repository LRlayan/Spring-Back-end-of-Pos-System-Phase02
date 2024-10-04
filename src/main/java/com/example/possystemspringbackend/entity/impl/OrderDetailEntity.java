package com.example.possystemspringbackend.entity.impl;

import com.example.possystemspringbackend.entity.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "orderDetail")
public class OrderDetailEntity implements SuperEntity {
    @Id
    private String id;
    private String orderId;
    private LocalDate date;
    private String customerId;
    private String customerName;
    private String customerCity;
    private String customerTel;
    private String itemCode;
    private String itemName;
    private int orderQTY;
    private double unitPrice;
}
