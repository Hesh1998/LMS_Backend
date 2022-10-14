package com.example.LMS.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer extends User{

    public Lecturer(User user) {
        super.setId(user.getId());
        super.setName(user.getName());
        super.setEmail(user.getEmail());
        super.setPassword(user.getPassword());
        super.setRole(user.getRole());
    }

}
