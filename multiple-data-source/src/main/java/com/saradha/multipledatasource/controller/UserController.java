package com.saradha.multipledatasource.controller;

import com.saradha.multipledatasource.model.user.User;
import com.saradha.multipledatasource.services.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    Userservice userservice;

    @GetMapping
    public List<User> getAllUser() {
        return userservice.getAllUsers();
    }
}
