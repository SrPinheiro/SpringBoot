package com.javaWeb.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;
@RestController
@RequestMapping(value="/ping")
public class PingResource {
	
	@GetMapping
	public ResponseEntity<String> findAll(HttpServletRequest request){
		return ResponseEntity.ok().body("pong");
	}

}
