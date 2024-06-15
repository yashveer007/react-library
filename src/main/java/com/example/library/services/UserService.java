package com.example.library.services;

import com.example.library.entities.User;

public interface UserService {

    User addUser(User user);
    User deleteUser(User user);
    String login(String userName, String password);
}
