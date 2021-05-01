package com.saradha.multipledatasource.services;

import com.saradha.multipledatasource.model.contact.Contact;
import com.saradha.multipledatasource.repository.contact.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    ContactRepository contactRepository;

    public List<Contact> getAllContact() {
       return contactRepository.findAll();
    }

}
