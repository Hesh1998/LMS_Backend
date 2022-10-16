package com.example.LMS.controller;

import com.example.LMS.DTO.UserDTO;
import com.example.LMS.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.ValidationAnnotationUtils;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping
public class UserController {
        @Autowired
        private final UserService userservice;

        @PostMapping(value = "/register", produces = APPLICATION_JSON_VALUE , consumes = APPLICATION_JSON_VALUE )
        public boolean Register(@RequestBody UserDTO newDto){
            return userservice.saveUser(newDto);
        }
}
