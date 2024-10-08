package com.example.possystemspringbackend.customStatusCode;

import com.example.possystemspringbackend.dto.CustomerStatus;
import com.example.possystemspringbackend.dto.ItemStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorStatus implements CustomerStatus, ItemStatus {
    private Integer Status;
    private String statusMessage;
}
