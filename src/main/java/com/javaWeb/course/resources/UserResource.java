package com.javaWeb.course.resources;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RestController;
import com.javaWeb.course.entities.User;
import com.javaWeb.course.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<Object> findAll(HttpServletRequest request){
		List<User> listUsers = userService.findAll();

		return ResponseEntity.ok().body(listUsers);		
	}	

	@GetMapping(value="/{id}")
	public ResponseEntity<Object> findById(@PathVariable Long id){
		if (userService.existsById(id))
			return ResponseEntity.ok().body(userService.findById(id).toUserDTO());

		return ResponseEntity.badRequest().body("Invalid id");
	}

	@PostMapping
	public ResponseEntity<Object> CreateUser(@RequestBody User user){
		
		if(user.isValid()){
			User u = userService.CreateUser(user);
			System.out.println(u);
			return ResponseEntity.ok().body(user);
		}
		
		return ResponseEntity.badRequest().body("usuario nao é valido");
	}
}


