package com.javaWeb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javaWeb.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}