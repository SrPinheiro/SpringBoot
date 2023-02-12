package com.javaWeb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

<<<<<<< HEAD
import jakarta.servlet.http.HttpServletRequest;

=======
>>>>>>> 88c5b2dfd526d1a3b11cf10a12f628ebed93049a
@RestController
@RequestMapping(value="/ping")
public class PingResource {
	
	@GetMapping
<<<<<<< HEAD
	public ResponseEntity<String> findAll(HttpServletRequest request){
		String ipAndress = request.getRemoteAddr();
		String response = String.format("<h1>Your ipAndress are: %s <h1>", ipAndress);
		return ResponseEntity.ok().body(response);
=======
	public ResponseEntity<String> findAll(){
		return ResponseEntity.ok().body("<h1>pong</h1>");
>>>>>>> 88c5b2dfd526d1a3b11cf10a12f628ebed93049a
	}

}
