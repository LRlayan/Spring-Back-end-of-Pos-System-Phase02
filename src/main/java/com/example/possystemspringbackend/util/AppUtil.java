package com.example.possystemspringbackend.util;

import java.util.UUID;

public class AppUtil {
    public String generateCustomerId(){
        return "CUSTOMER-" + UUID.randomUUID();
    }
    public String generateItemId(){
        return "ITEM-" + UUID.randomUUID();
    }
    public String generateOrderId(){
        return "ORDER-" + UUID.randomUUID();
    }
    public String generateOrderDetailId(){
        return "ORDER_DETAIL-" + UUID.randomUUID();
    }
}
