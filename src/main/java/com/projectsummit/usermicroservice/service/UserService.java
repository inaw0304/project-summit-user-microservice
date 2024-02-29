package com.projectsummit.usermicroservice.service;

import com.projectsummit.usermicroservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();
    public Optional<User> getUserById(Long userId);

}
