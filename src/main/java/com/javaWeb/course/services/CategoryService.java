package com.javaWeb.course.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaWeb.course.entities.Category;
import com.javaWeb.course.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
        
    }

    public Category CreateCategory(Category u){
        return repository.save(u);
    }

    public Category findById(Long id){
        return repository.findById(id).get();
    }

    public boolean existsById(Long id){
        return repository.existsById(id);
    }

}
