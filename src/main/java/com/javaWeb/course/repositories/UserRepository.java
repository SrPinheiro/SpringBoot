package com.javaWeb.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.javaWeb.course.entities.User;
public interface UserRepository extends JpaRepository<User, Long>{
    
}