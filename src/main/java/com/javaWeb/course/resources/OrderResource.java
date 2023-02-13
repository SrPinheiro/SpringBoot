package com.javaWeb.course.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javaWeb.course.entities.Order;
import com.javaWeb.course.services.OrderService;

@RestController
@RequestMapping(value="/order")
public class OrderResource {
    @Autowired
    private OrderService orders;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok().body(orders.findAll());
    }

    @GetMapping
    @RequestMapping(value="/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(orders.findById(id));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(){
        // Order o = new Order();
        // o.setClient();
        
        return null;
    }
    
}
