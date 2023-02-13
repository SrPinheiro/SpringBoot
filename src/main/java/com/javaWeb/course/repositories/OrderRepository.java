package com.javaWeb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaWeb.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
    
}