package com.projectsummit.usermicroservice.service;

import com.projectsummit.usermicroservice.dto.UserCreatePatchDeleteResponse;
import com.projectsummit.usermicroservice.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAllUsers();
    public Optional<User> getUserById(Long userId);

    UserCreatePatchDeleteResponse createUser(User user);

    UserCreatePatchDeleteResponse updateUserById(Long userId, User user);

    UserCreatePatchDeleteResponse deleteUserById(Long userId);
}
