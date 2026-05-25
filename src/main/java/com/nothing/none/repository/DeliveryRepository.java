package com.nothing.none.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nothing.none.model.entity.Delivery;

@Repository
public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {

    
} 
