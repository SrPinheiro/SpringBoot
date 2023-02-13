package com.javaWeb.course.config;

import java.time.Instant;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import com.github.javafaker.Faker;
import com.javaWeb.course.entities.Order;
import com.javaWeb.course.entities.OrderStatus;
import com.javaWeb.course.entities.User;
import com.javaWeb.course.repositories.OrderRepository;
import com.javaWeb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {
		addUsers();
		addOrders();
        
    }


	private void addOrders() {		
		ArrayList<Order> li = new ArrayList<>();

		for(int i = 0; i <= 10; i++)
			li.add(new Order(null,Instant.now(), OrderStatus.WAITING_PAYMENT ,userRepository.findById( (long)(1+Math.random()*9) ).get()));
		
		orderRepository.saveAll(li);
	}


	public void addUsers(){
		Faker gerador = new Faker();
		ArrayList<User> li = new ArrayList<>();


		for(int i = 0; i <= 10; i++)
        	li.add(new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password()));

		userRepository.saveAll(li);
		

		

	}
}
