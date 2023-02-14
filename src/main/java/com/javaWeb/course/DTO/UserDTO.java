package com.javaWeb.course.DTO;

import java.io.Serializable;

import com.javaWeb.course.entities.User;

public class UserDTO implements Serializable {
    private String name;
    private String email;
    private String phone;


    public User toUser(){
        User u = new User();
        u.setName(name);
        u.setEmail(email);
        u.setPhone(phone);
        return u;
    }


    public UserDTO(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public UserDTO(){
        
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    
    
    
}
