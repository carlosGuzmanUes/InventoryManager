package com.nothing.none.repository;

import java.util.UUID;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nothing.none.model.entity.Inventory;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, UUID> {
    
}
