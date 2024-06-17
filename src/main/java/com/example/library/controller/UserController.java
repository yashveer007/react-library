package com.example.library.controller;

import com.example.library.dto.LoginDto;
import com.example.library.entities.User;
import com.example.library.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    private ResponseEntity<User> addUser(@RequestBody User user){
        User addedUser = service.addUser(user);
        return  new ResponseEntity<>(addedUser, HttpStatus.OK);
    }

    @PostMapping("/login")
    private ResponseEntity<String> login(@RequestBody LoginDto loginDto){
        String userName = service.login(loginDto.getUserName(), loginDto.getPassword());
        return  new ResponseEntity<>(userName, HttpStatus.OK);
    }
}
