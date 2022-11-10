package com.stage.freeclub.controller;

import com.stage.freeclub.entity.Contact;
import com.stage.freeclub.repository.ContactRepository;
import com.stage.freeclub.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    @Autowired
    private  ContactService service;
    private ContactRepository repo;


    @PostMapping("/add")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact){
         Contact newContact=service.addContact(contact);
         return new ResponseEntity<>(newContact, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts(){
        List<Contact> contacts= service.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable("id")  Long id){
        Contact contact=service.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }


    @PutMapping("/edit/{id}")
    public ResponseEntity<Contact> updateContact(@RequestBody Contact contact ,@PathVariable("id") Long id ){
        Contact updateContact =service.updateContact(contact,id);
            return new ResponseEntity<>(updateContact, HttpStatus.OK);
        }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteContact(@PathVariable("id") Long id ){
         service.deleteContact(id);
         return new ResponseEntity<>(HttpStatus.OK);
    }
}
