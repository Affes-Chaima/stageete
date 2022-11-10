package com.stage.freeclub.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


import com.stage.freeclub.entity.Activity;
import com.stage.freeclub.entity.User;
import com.stage.freeclub.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService service;

    @PostMapping("/signup")
    public ResponseEntity<User> registerUser(@RequestBody User user) {

        /*String mail=user.getEmail();
        if(mail != null && !"".equals("mail")){
            User newUser= service.getUserByEmail(mail);
            if(newUser != null){
                throw new Exception("User with this mail already exists");
            }
        }*/

        User user1= service.saveUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);

    }


    @GetMapping("/users")
    public ResponseEntity<List<User>> getUserList(){
        List<User> users=service.getUserList();
        return new ResponseEntity<>(users,HttpStatus.ACCEPTED);
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id")  Long id){
        User user=service.getUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }



    @PostMapping("/signin")
    public ResponseEntity<User> loginUser(@RequestBody User user) throws Exception {
        String mail=user.getEmail();
        String password=user.getPassword();
        User currentUser= null;
        if(mail != null && password != null){
            currentUser=service.getUserByEmailAndPassword(mail,password);
        }
        if (currentUser == null){
            throw new Exception("Bad credentials");
        }
        return new ResponseEntity<>(currentUser,HttpStatus.ACCEPTED);
    }


}
