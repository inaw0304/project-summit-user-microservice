package com.projectsummit.usermicroservice.dto;
import com.projectsummit.usermicroservice.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserCreatePatchDeleteResponse {

    private String status;
    private Optional<User> user;
}
