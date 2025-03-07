package com.example.shop.dto;
import com.example.shop.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String code;
    private String name;
    private String avatarUrl;
    private Integer gender;
    private String username;
    private boolean enabled;
    private Role role;
    private LocalDate date;
    private LocalDate dob;
    private String address;
    private String email;
    private String phone;


    public UserDTO(String username, String roles) {
    }
}
