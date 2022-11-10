package com.stage.freeclub.service;

import com.stage.freeclub.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.stage.freeclub.repository.ContactRepository;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private  ContactRepository repo;


    public Contact addContact(Contact contact){
    return repo.save(contact);
    }
    /* contact.setName(contact.getName());
        contact.setMobile(contact.getMobile());
        contact.setCompany(contact.getCompany());
        contact.setTitle(contact.getTitle());*/

    public List<Contact> getAllContacts(){
        return repo.findAll();
    }
    public Contact  getContactById(Long id){
        return repo.findById(id).orElse(null);
    }
    public Contact  getContactByName(String name){
        return repo.findByName(name);
    }
    public void deleteContact(Long id){
        repo.deleteById(id);
        }
    public Contact  updateContact(Contact contact,Long id){
        Contact contact1 =getContactById(id);
        contact1.setName(contact.getName());
        contact1.setMobile(contact.getMobile());
        contact1.setCompany(contact.getCompany());
        contact1.setTitle(contact.getTitle());
        return repo.save(contact1);
    }


}
