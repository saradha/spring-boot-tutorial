package com.saradha.multipledatasource.services;

import com.saradha.multipledatasource.model.user.User;
import com.saradha.multipledatasource.repository.user.UserReposiory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Userservice {

    @Autowired
    UserReposiory userReposiory;

    public List<User> getAllUsers() {
       return userReposiory.findAll();
    }
}
