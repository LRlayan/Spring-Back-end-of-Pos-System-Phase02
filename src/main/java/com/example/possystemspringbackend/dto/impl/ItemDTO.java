package com.example.possystemspringbackend.dto.impl;

import com.example.possystemspringbackend.dto.SuperDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemDTO implements SuperDTO {
    private String id;
    private String itemCode;
    private String itemName;
    private int QTYOnHand;
    private double unitPrice;
}
