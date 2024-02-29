package com.projectsummit.usermicroservice.service;

import com.projectsummit.usermicroservice.dao.UserDAO;
import com.projectsummit.usermicroservice.dto.UserCreatePatchDeleteResponse;
import com.projectsummit.usermicroservice.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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

    @Override
    @Transactional
    public UserCreatePatchDeleteResponse createUser(User user) {
        userDAO.save(user);
        return new UserCreatePatchDeleteResponse("success",getUserById(user.getId()));
    }

    @Override
    @Transactional
    public UserCreatePatchDeleteResponse updateUserById(Long userId, User user) {
        boolean exists = userDAO.existsById(userId);
        if(!exists){
            return new UserCreatePatchDeleteResponse("User with given user "+userId+" does not exist!",null);
        }

        Optional<User> foundUser = userDAO.findById(userId);
        if(foundUser.isPresent()){
            if(user.getFirstName()!=null){
                foundUser.get().setFirstName(user.getFirstName());
            }

            if(user.getLastName()!=null){
                foundUser.get().setLastName(user.getLastName());
            }

            if(user.getDob()!=null){
                foundUser.get().setDob(user.getDob());
            }

            if(user.getGender()!=null){
                foundUser.get().setGender(user.getGender());
            }

            if(user.getEmail()!=null){
                foundUser.get().setEmail(user.getEmail());
            }

        }else{
            return new UserCreatePatchDeleteResponse("User with given user "+userId+" does not exist!",null);
        }
        return new UserCreatePatchDeleteResponse("success",foundUser);
    }

    @Override
    @Transactional
    public UserCreatePatchDeleteResponse deleteUserById(Long userId) {

        boolean exists = userDAO.existsById(userId);
        if(!exists){
            return new UserCreatePatchDeleteResponse("User with given user "+userId+" does not exist!",null);
        }

        Optional<User> user = userDAO.findById(userId);
        userDAO.deleteById(userId);
        return new UserCreatePatchDeleteResponse("success",user);
    }


}
