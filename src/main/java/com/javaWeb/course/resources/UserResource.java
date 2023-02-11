package com.javaWeb.course.resources;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javaWeb.course.entities.User;

@RestController
@RequestMapping(value = "/Users")
public class UserResource {
	
	@GetMapping
	public ResponseEntity<ArrayList<User>> findAll(){
		User u1 = new User(1L, "Maria", "maria@gmail.com", "4002-8922", "123");
		User u2 = new User(1L, "Maria1", "maria@gmail.com", "4002-8922", "123");
		User u3 = new User(1L, "Maria2", "maria@gmail.com", "4002-8922", "123");
		User u4 = new User(1L, "Maria3", "maria@gmail.com", "4002-8922", "123");
		User u5 = new User(1L, "Maria4", "maria@gmail.com", "4002-8922", "123");
		
		ArrayList<User> li = new ArrayList<>();
		li.add(u1);
		li.add(u2);
		li.add(u3);
		li.add(u4);
		li.add(u5);
		return ResponseEntity.ok().body(li);
	}
	
}


