package com.example.possystemspringbackend.dto.impl;

import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO , ItemStatus {
    private String itemCode;
    private String itemName;
    private int qtyOnHand;
    private double unitPrice;
    private List<OrderDetailDTO> orderList;
}
