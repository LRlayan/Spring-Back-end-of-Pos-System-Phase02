package com.example.possystemspringbackend.repository;

import com.example.possystemspringbackend.entity.impl.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity,String> {
}
