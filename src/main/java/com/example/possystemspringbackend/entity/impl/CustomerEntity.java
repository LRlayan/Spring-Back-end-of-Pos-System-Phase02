package com.example.possystemspringbackend.entity.impl;

import com.example.possystemspringbackend.entity.SuperEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "customer")
public class CustomerEntity implements SuperEntity {
    @Id
    private String id;
    private String customerId   ;
    private String name;
    private String city;
    private String tel;
    @OneToMany(mappedBy = "customer")
    private List<OrderEntity> orderList;
}
