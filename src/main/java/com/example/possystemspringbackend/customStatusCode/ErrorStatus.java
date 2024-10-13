package com.example.possystemspringbackend.customStatusCode;

import com.example.possystemspringbackend.dto.CustomerStatus;
import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorStatus implements CustomerStatus, ItemStatus, OrderStatus {
    private Integer Status;
    private String statusMessage;
}
