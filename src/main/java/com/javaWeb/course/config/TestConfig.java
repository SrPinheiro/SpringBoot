package com.javaWeb.course.config;



import java.time.Instant;
import java.util.ArrayList;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.github.javafaker.Faker;
import com.javaWeb.course.entities.Category;
import com.javaWeb.course.entities.Order;
import com.javaWeb.course.entities.OrderItem;
import com.javaWeb.course.entities.OrderStatus;
import com.javaWeb.course.entities.Product;
import com.javaWeb.course.entities.User;
import com.javaWeb.course.repositories.CategoryRepository;
import com.javaWeb.course.repositories.OrderItemRepository;
import com.javaWeb.course.repositories.OrderRepository;
import com.javaWeb.course.repositories.ProductRepository;
import com.javaWeb.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

	public static Faker gerador = new Faker(new Locale("pt-br"));

    @Override
    public void run(String... args) throws Exception {
		addUsers();
        addCategory(); 
		addProducts();
		addOrders();
		// addOrderItens();
	
    }

	private void addOrderItens(){
		ArrayList<OrderItem> li = new ArrayList<>();

		for(int i = 0; i <= 10; i++){
			var p = productRepository.findById((long)(1+Math.random()*9)).get();
			li.add(new OrderItem(orderRepository.findById((long)(1+Math.random()*9)).get(), p, (int)(1+Math.random()*9), p.getPrice()));
		}

		orderItemRepository.saveAll(li);
		
	}


	private void addOrders() {		
		ArrayList<Order> li = new ArrayList<>();

		for(int i = 0; i <= 10; i++)
			li.add(new Order(null,Instant.now(), OrderStatus.WAITING_PAYMENT ,userRepository.findById( (long)(1+Math.random()*9) ).get()));

		orderRepository.saveAll(li);
		
	}


	public void addUsers(){
		ArrayList<User> li = new ArrayList<>();


		for(int i = 0; i <= 10; i++)
        	li.add(new User(null, gerador.name().fullName(), gerador.internet().emailAddress(), gerador.phoneNumber().cellPhone(), gerador.internet().password()));

		userRepository.saveAll(li);
	
	}

	public void addCategory(){
		ArrayList<Category> li = new ArrayList<>();

		for(int i = 0; i <= 10; i++)
			li.add( new Category(null, gerador.commerce().department()));

		categoryRepository.saveAll(li);
	}

	public void addProducts(){
		ArrayList<Product> li = new ArrayList<>();

		for(int i = 0; i<=10; i++)
			li.add(new Product(null, gerador.commerce().productName(),gerador.aviation().METAR() , 100 + Math.random() * 3423 ,gerador.internet().avatar()));

		productRepository.saveAll(li);

		for(Product p : li){
			for(int i = 0; i <= (int)(1 + Math.random() * 9); i++)
					p.getCategories().add(categoryRepository.findById((long)(1 + Math.random() * 9)).get());

		}
		productRepository.saveAll(li);

	}

	public void addOrderItem(){
		ArrayList<Order> li = (ArrayList) orderRepository.findAll();

		

	
	}

}
