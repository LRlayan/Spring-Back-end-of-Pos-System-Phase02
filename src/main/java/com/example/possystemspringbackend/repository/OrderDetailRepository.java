package com.example.possystemspringbackend.repository;

import com.example.possystemspringbackend.entity.impl.OrderDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetailEntity,String> {
}
