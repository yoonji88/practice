package com.kmong.demo.repositories;

import java.util.List;

import com.kmong.demo.models.Order;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository public interface OrderRepository extends JpaRepository<Order, String> { 
    
  
}