package com.example.possystemspringbackend.service;

import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.impl.ItemDTO;

import java.util.List;

public interface ItemService {
    void saveItem(ItemDTO itemDTO);
    void updateItem(String itemId,ItemDTO itemDTO);
    void deleteItem(String itemId);
    ItemStatus getItem(String itemId);
    List<ItemDTO> getAllItem();
}
