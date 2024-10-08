package com.example.possystemspringbackend.customStatusCode;

import com.example.possystemspringbackend.dto.CustomerStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ErrorStatus implements CustomerStatus {
    private Integer Status;
    private String statusMessage;
}
