package com.example.LMS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class UserDTO {
    private String name;
    private String email;
    private String password;
    private String role;
}
