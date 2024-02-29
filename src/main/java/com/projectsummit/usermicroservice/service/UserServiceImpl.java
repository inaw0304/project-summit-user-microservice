package com.projectsummit.usermicroservice.service;

import com.projectsummit.usermicroservice.dao.UserDAO;
import com.projectsummit.usermicroservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }


    @Override
    public List<User> getAllUsers() {
        return userDAO.findAll();
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        boolean exists = userDAO.existsById(userId);

//        if(!exists){
//            throw new ProductNotFoundException("Product not found - "+ userId);
//        }

        Optional<User> user = userDAO.findById(userId);
        return user;
    }
}
