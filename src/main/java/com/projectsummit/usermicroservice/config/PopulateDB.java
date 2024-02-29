package com.projectsummit.usermicroservice.config;

import com.projectsummit.usermicroservice.dao.UserDAO;
import com.projectsummit.usermicroservice.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PopulateDB {

    @Bean
    CommandLineRunner commandLineRunner(UserDAO userDAO){

        return args -> {

            // Create an ArrayList to hold User objects
            List<User> users = new ArrayList<>();

            users.add(new User("John", "Doe", new Date(90, 0, 1), "Male", "Regular", "john@example.com"));
            users.add(new User("Alice", "Smith", new Date(88, 5, 15), "Female", "Regular", "alice@example.com"));
            users.add(new User("Bob", "Johnson", new Date(92, 8, 20), "Male", "Regular", "bob@example.com"));
            users.add(new User("Emily", "Brown", new Date(87, 11, 5), "Female", "Regular", "emily@example.com"));
            users.add(new User("Michael", "Wilson", new Date(91, 2, 10), "Male", "Regular", "michael@example.com"));

            userDAO.saveAll(users);

        };

    }
}
