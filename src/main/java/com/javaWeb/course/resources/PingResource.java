package com.javaWeb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/ping")
public class PingResource {
	
	@GetMapping
	public ResponseEntity<String> findAll(){
		return ResponseEntity.ok().body("<h1>pong</h1>");
	}

}
