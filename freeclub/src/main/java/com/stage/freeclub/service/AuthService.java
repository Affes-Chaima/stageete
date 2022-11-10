package com.stage.freeclub.service;

import com.stage.freeclub.entity.Activity;
import com.stage.freeclub.entity.User;
import com.stage.freeclub.repository.AuthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class AuthService {

    @Autowired
    private AuthRepository repo;

    public User saveUser(User user){
        return repo.save(user);
    }

    public User getUserByEmail(String email){
        return repo.findByEmail(email);
    }

    public User getUserById(Long id){return repo.findById(id).orElse(null);}

    public List<User> getUserList(){
        return repo.findAll();
    }


    public User getUserByEmailAndPassword(String email,String password){
        return repo.findByEmailAndPassword(email,password);
    }
}
