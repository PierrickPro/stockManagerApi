package com.myapp.stockmanager.service;

import com.myapp.stockmanager.exception.UserNotFoundException;
import com.myapp.stockmanager.model.Item;
import com.myapp.stockmanager.repo.ItemRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class ItemService {
    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public Item addItem(Item item){
        item.setItemCode(UUID.randomUUID().toString());
        return itemRepo.save(item);
    }

    public List<Item> findAllItems(){
        return itemRepo.findAll();
    }

    public Item updateItem(Item item){
      return itemRepo.save(item);
    }

    public Item findItemById(Long id){
        return itemRepo.findItemById(id)
                .orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteItem(Long id){
        itemRepo.deleteItemById(id);
    }
}
