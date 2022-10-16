package com.example.LMS.service;

import com.example.LMS.DTO.UserDTO;
import com.example.LMS.model.User;
import com.example.LMS.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserService {
    @Autowired
    private final UserRepository userrepo;

    public boolean saveUser(UserDTO newUser){
        boolean response = false;
        try {
            User user = new User(newUser.getName(), newUser.getEmail(), newUser.getPassword(),newUser.getRole());
            userrepo.save(user);
            response = true;
        }catch (Exception e){
            System.out.println("Exception on User Service Layer");
        }
        return response;
    }
}
