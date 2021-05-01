package com.saradha.multipledatasource.controller;

import com.saradha.multipledatasource.model.contact.Contact;
import com.saradha.multipledatasource.model.user.User;
import com.saradha.multipledatasource.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contact")
public class ContactController {

    @Autowired
    ContactService contactService;

    @GetMapping
    public List<Contact> getAllContact(){
       return contactService.getAllContact();

    }
}
