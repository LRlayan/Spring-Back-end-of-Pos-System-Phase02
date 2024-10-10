package com.example.possystemspringbackend.controller;

import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.impl.ItemDTO;
import com.example.possystemspringbackend.dto.impl.OrderDetailDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orderDetails")
@CrossOrigin
public class OrderDetailController {
    @PostMapping
    public void saveOrderDetail(OrderDetailDTO orderDetailDTO) {

    }
    @PutMapping(value = "/{orderDetailId}")
    public void updateOrderDetail(@PathVariable("orderDetailId") String itemId, OrderDetailDTO orderDetailDTO) {

    }
    @DeleteMapping(value = "/{orderDetailId}")
    public void deleteOrderDetail(@PathVariable("orderDetailId") String orderDetailId) {

    }
    @GetMapping(value = "/{orderDetailId}")
    public ItemStatus getOrderDetail(@PathVariable("orderDetailId") String orderDetailId) {
        return null;
    }
    @GetMapping
    public List<ItemDTO> getAllOrderDetail() {
        return null;
    }
}
