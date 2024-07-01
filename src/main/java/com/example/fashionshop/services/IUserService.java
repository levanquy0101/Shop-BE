package com.example.fashionshop.services;

import com.example.fashionshop.dto.UserDTO;
import com.example.fashionshop.entities.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    boolean existsByUsername(String admin);

    User save(User user);

    User findById(Long id);
//    Optional<User> findById(Long id);

    User findByUsername(String username);
    UserDTO convertToDTO(User user);


//    List<User> findAllUserNotIn();
    List<User> findAllEmployeeExceptRoles(List<String> roleNames);

    void deleteEmployee(Long id);
}
