package com.javaWeb.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javaWeb.course.entities.User;
import com.javaWeb.course.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository users;

    public List<User> findAll(){
        return users.findAll();
        
    }

    public User CreateUser(User u){
        return users.save(u);
    }

    public User findById(Long id){
        return users.findById(id).get();
    }
}
