package com.example.library.controller;

import com.example.library.entities.User;
import com.example.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/add")
    private ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = service.addUser(user);
        return  new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    private ResponseEntity<User> login(@RequestBody User user){
        User addedUser = service.login(user.getUserName(), user.getPassword());
        return  new ResponseEntity<>(addedUser, HttpStatus.OK);
    }
}
