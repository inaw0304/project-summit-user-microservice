package com.projectsummit.usermicroservice.controller;

import com.projectsummit.usermicroservice.dto.UserCreatePatchDeleteResponse;
import com.projectsummit.usermicroservice.entity.User;
import com.projectsummit.usermicroservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getProducts(){
        return this.userService.getAllUsers();
    }

    @GetMapping("/users/{userId}")
    public Optional<User> getProductById(@PathVariable("userId") Long userId){
        return userService.getUserById(userId);
    }

    @PostMapping("/users")
    public UserCreatePatchDeleteResponse createNewProduct(@RequestBody User user){
        return userService.createUser(user);
    }

    @PatchMapping("/users/{userId}")
    public UserCreatePatchDeleteResponse updateUserById(@PathVariable("userId") Long userId, @RequestBody User user){
        return userService.updateUserById(userId,user);
    }

    @DeleteMapping("/users/{userId}")
    public UserCreatePatchDeleteResponse deleteUserById(@PathVariable("userId") Long userId){
        return userService.deleteUserById(userId);
    }



}
