package com.javaWeb.course.resources;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.javaWeb.course.entities.Order;
import com.javaWeb.course.entities.OrderStatus;
import com.javaWeb.course.services.OrderService;
import com.javaWeb.course.services.UserService;

@RestController
@RequestMapping(value="/order")
public class OrderResource {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        return ResponseEntity.ok().body(orderService.findAll());
    }

    @GetMapping
    @RequestMapping(value="/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(orderService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order o){
        System.out.println(o);
        
        if (o.getClient().getId() == null | userService.findById(o.getClient().getId()) == null)
            return ResponseEntity.badRequest().body(null);

        o.setClient(userService.findById(o.getClient().getId()));
        o.setMoment(Instant.now());
        o.setOrderStatus(OrderStatus.WAITING_PAYMENT);
        return ResponseEntity.ok().body(orderService.CreateOrder(o));
    }
    
}
