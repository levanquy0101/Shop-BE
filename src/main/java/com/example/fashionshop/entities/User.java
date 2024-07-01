package com.example.fashionshop.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String code;
    @Column
    private String name;
    @Column
    private String avatarUrl;
    @Column
    private Integer gender;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private boolean enabled;
    @ManyToOne
    @JoinColumn
    private Role role;
    @Column
    private LocalDate date;
    @Column
    private LocalDate dob;
    @Column
    private String address;
    @Column
    private String email;
    @Column
    private String phone;
    
}
