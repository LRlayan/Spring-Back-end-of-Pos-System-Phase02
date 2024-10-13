package com.example.possystemspringbackend.controller;

import com.example.possystemspringbackend.customStatusCode.ErrorStatus;
import com.example.possystemspringbackend.dto.OrderStatus;
import com.example.possystemspringbackend.dto.impl.OrderDTO;
import com.example.possystemspringbackend.exception.DataPersistException;
import com.example.possystemspringbackend.service.OrderService;
import com.example.possystemspringbackend.util.Regex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/orders")
@CrossOrigin
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDTO orderDTO){
        orderDTO.setOrderID(orderDTO.getOrderID());
        try{
            orderService.saveOrder(orderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping(value = "/{orderId}",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> updateOrder(@PathVariable("orderId") String orderId,@RequestBody OrderDTO orderDTO){
        try{
            orderService.updateOrder(orderId,orderDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable("orderId") String orderId){
        try{
            if (!Regex.orderIdValidate(orderId).matches()) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            orderService.deleteOrder(orderId);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch (DataPersistException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{orderId}")
    public OrderStatus getOrder(@PathVariable("orderId") String orderId){
        if (!Regex.orderIdValidate(orderId).matches()){
            return new ErrorStatus(1,"OrderId is Not valid!");
        }
        return orderService.getOrder(orderId);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrderDTO> getAllOrders(){
        return orderService.getAllOrder();
    }
}
