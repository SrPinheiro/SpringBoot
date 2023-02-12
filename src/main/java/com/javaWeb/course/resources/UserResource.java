package com.javaWeb.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParser;
import com.javaWeb.course.entities.User;
import com.javaWeb.course.services.UserService;

@RestController
@RequestMapping(value = "/Users")
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<List<User>> findAll(HttpServletRequest request){
		List<User> listUsers = service.findAll();

		return ResponseEntity.ok().body(listUsers);		
	}

	@GetMapping(value="/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User u = service.findById(id);
		return u != null ? ResponseEntity.ok().body(u) : ResponseEntity.badRequest().body(null);
	}

	@PostMapping
	public ResponseEntity<User> CreateUser(@RequestBody User user){
		if(user.isValid()){
			User u = service.CreateUser(user);
			System.out.println(u);
			return ResponseEntity.ok().body(user);
		}
		
		return ResponseEntity.badRequest().body(null);
	}
}


