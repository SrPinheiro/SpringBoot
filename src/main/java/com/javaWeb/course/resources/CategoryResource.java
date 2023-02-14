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
import com.javaWeb.course.entities.Category;
import com.javaWeb.course.services.CategoryService;
import com.javaWeb.course.services.UserService;

@RestController
@RequestMapping(value="/Categories")
public class CategoryResource {
    @Autowired
    private CategoryService CategoryService;


    @GetMapping
    public ResponseEntity<List<Category>> findAll(){
        return ResponseEntity.ok().body(CategoryService.findAll());
    }

    @GetMapping
    @RequestMapping(value="/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        return ResponseEntity.ok().body(CategoryService.findById(id));
    }
    
}
