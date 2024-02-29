package com.projectsummit.usermicroservice.entity;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "users")

@Data
@NoArgsConstructor
@AllArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String userType;
    private String email;
    @Transient
    private int age;

    public User(String firstName, String lastName, Date dob, String gender, String userType, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.gender = gender;
        this.userType = userType;
        this.email = email;
        this.age = calculateAge(dob);
    }

    // Method to calculate age based on date of birth
    private int calculateAge(Date dob) {
        if (dob == null) {
            return 0; // Return 0 if DOB is not provided
        }
        LocalDate now = LocalDate.now();
        LocalDate birthday = new java.sql.Date(dob.getTime()).toLocalDate();
        return Period.between(birthday, now).getYears();
    }
}
