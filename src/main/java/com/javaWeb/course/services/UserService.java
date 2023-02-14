package com.javaWeb.course.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.catalina.realm.UserDatabaseRealm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaWeb.course.DTO.UserDTO;
import com.javaWeb.course.entities.User;
import com.javaWeb.course.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
        
    }

    public User CreateUser(User u){
        return repository.save(u);
    }

    public User findById(Long id){
        return repository.findById(id).get();
    }

    public boolean existsById(Long id){
        return repository.existsById(id);
    }

    public List<UserDTO> findAllDTO(){
        return repository.findAll().stream().map(User::toUserDTO).collect(Collectors.toList());
    }
}
