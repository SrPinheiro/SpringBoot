package com.javaWeb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaWeb.course.entities.OrderItem;
import com.javaWeb.course.repositories.OrderItemRepository;

@Service
public class OrderItemService {
    @Autowired
    private OrderItemRepository repository;

    public List<OrderItem> findAll(){
        return repository.findAll();
        
    }

    public OrderItem CreateOrderItem(OrderItem u){
        return repository.save(u);
    }

    public OrderItem findById(Long id){
        return repository.findById(id).get();
    }

    public boolean existsById(Long id){
        return repository.existsById(id);
    }

}
