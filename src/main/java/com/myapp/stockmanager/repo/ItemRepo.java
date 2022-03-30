package com.myapp.stockmanager.repo;

import com.myapp.stockmanager.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepo extends JpaRepository<Item, Long> {
    void deleteItemById(Long id); //Query Method: Spring understands what this method does by naming convention
    Optional<Item> findItemById(Long id);
}
