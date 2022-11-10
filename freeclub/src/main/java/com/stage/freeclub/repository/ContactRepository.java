package com.stage.freeclub.repository;

import com.stage.freeclub.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    Contact findByName(String name);
}
