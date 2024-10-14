package com.example.possystemspringbackend.service.impl;

import com.example.possystemspringbackend.customStatusCode.ErrorStatus;
import com.example.possystemspringbackend.dto.ItemStatus;
import com.example.possystemspringbackend.dto.impl.ItemDTO;
import com.example.possystemspringbackend.entity.impl.ItemEntity;
import com.example.possystemspringbackend.exception.CustomerNotFoundException;
import com.example.possystemspringbackend.exception.DataPersistException;
import com.example.possystemspringbackend.exception.ItemNotFoundException;
import com.example.possystemspringbackend.repository.ItemRepository;
import com.example.possystemspringbackend.service.ItemService;
import com.example.possystemspringbackend.util.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(ItemServiceImpl.class);
    @Override
    public void saveItem(ItemDTO itemDTO) {
        logger.info("Attempting to save item with code: {}", itemDTO.getItemCode());
        ItemEntity item = itemRepository.save(mapping.toItemEntity(itemDTO));
        if (item==null){
            logger.error("Item with code: {} could not be saved", itemDTO.getItemCode());
            throw new DataPersistException("Customer Note Saved");
        }else {
            logger.info("Item with code: {} has been saved successfully", itemDTO.getItemCode());
        }
    }

    @Override
    public void updateItem(String itemCode, ItemDTO itemDTO) {
        logger.info("Attempting to update item with code: {}", itemCode);
        Optional<ItemEntity> tmpItem = itemRepository.findById(itemCode);
        if (tmpItem.isPresent()){
            tmpItem.get().setItemName(itemDTO.getItemName());
            tmpItem.get().setQTYOnHand(itemDTO.getQTYOnHand());
            tmpItem.get().setUnitPrice(itemDTO.getUnitPrice());
            logger.info("Item with code: {} has been updated successfully", itemCode);
        } else {
            logger.warn("Item with code: {} not found for update", itemCode);
        }
    }

    @Override
    public void deleteItem(String itemCode) {
        Optional<ItemEntity> tmpItem = itemRepository.findById(itemCode);
        if (!tmpItem.isPresent()){
            logger.info("Attempting to delete item with code: {}", itemCode);
            throw new ItemNotFoundException("Item code with " + itemCode + "Not Found!");
        }else {
            itemRepository.deleteById(itemCode);
            logger.info("Item with code: {} has been deleted successfully", itemCode);
        }
    }

    @Override
    public ItemStatus getItem(String itemCode) {
        logger.info("Fetching item with code: {}", itemCode);
        if (itemRepository.existsById(itemCode)){
            logger.info("Item with code: {} found", itemCode);
            return mapping.toItemDTO(itemRepository.getReferenceById(itemCode));
        }else {
            logger.warn("Item with code: {} not found", itemCode);
            return new ErrorStatus(2,"Selected item not found");
        }
    }

    @Override
    public List<ItemDTO> getAllItem() {
        logger.info("Fetching all items");
        List<ItemDTO> items = mapping.toItemList(itemRepository.findAll());

        if (items.isEmpty()) {
            logger.warn("No items found");
        } else {
            logger.info("Number of items found: {}", items.size());
        }
        return items;
    }
}
