package com.example.library.services;

import com.example.library.dao.UserDao;
import com.example.library.entities.User;
import com.example.library.exception.NoAccountFoundException;
import com.example.library.exception.SomethingWentWrongException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao dao;

    @Override
    public User addUser(User user) {
        try{
            User save = dao.save(user);
            return user;
        }catch( Exception ex){
            throw new SomethingWentWrongException(ex.getMessage());
        }
    }

    @Override
    public User deleteUser(User user) {
        return null;
    }

    @Override
    public String login(String userName, String password) {

        Optional<User> optionalUser = dao.findById(userName);
        if(optionalUser.isPresent()){
            User user =  optionalUser.get();
            if(user.getPassword().equals(password)){
                return user.getUserName();
            }
            throw new NoAccountFoundException("Enter Incorrect Password");
        }else{
            throw new NoAccountFoundException("No Account Found");
        }
    }
}
