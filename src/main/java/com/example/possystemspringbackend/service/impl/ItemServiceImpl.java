package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.customStatusCode.ErrorStatus;
import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.impl.ItemDTO;
import com.example.possystemspringbackend.entity.impl.ItemEntity;
import com.example.possystemspringbackend.exception.CustomerNotFoundException;
import com.example.possystemspringbackend.exception.DataPersistException;
import com.example.possystemspringbackend.repository.ItemRepository;
import com.example.possystemspringbackend.service.ItemService;
import com.example.possystemspringbackend.util.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private Mapping mapping;

    @Override
    public void saveItem(ItemDTO itemDTO) {
        ItemEntity item = itemRepository.save(mapping.toItemEntity(itemDTO));
        if (item==null){
            throw new DataPersistException("Customer Note Saved");
        }
    }

    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {
        Optional<ItemEntity> tmpItem = itemRepository.findById(itemCode);
        if (tmpItem.isPresent()){
            tmpItem.get().setItemName(itemDTO.getItemName());
            tmpItem.get().setQTYOnHand(itemDTO.getQTYOnHand());
            tmpItem.get().setUnitPrice(itemDTO.getUnitPrice());
        }
    }

    @Override
    public void deleteItem(String itemCode) {
    }

    @Override
    public ItemStatus getItem(String itemCode) {
        return null;
    }

    @Override
    public List<ItemDTO> getAllItem() {
        return null;
    }
}
