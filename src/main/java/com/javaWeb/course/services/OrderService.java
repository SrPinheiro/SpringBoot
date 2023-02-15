package com.javaWeb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaWeb.course.entities.Order;
import com.javaWeb.course.repositories.OrderRepository;

@Service
public class OrderService {
    @Autowired
    private OrderRepository repository;

    public List<Order> findAll(){
        return repository.findAll();
        
    }

    public Order CreateOrder(Order u){
        return repository.save(u);
    }

    public Order findById(Long id){
        return repository.findById(id).get();
    }

    public boolean existsById(Long id){
        return repository.existsById(id);
    }

}
