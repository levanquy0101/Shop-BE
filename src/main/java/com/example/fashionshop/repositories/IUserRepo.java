package com.example.fashionshop.repositories;

import com.example.fashionshop.dto.UserDTO;
import com.example.fashionshop.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface IUserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
    boolean existsByUsername(String admin);
//    Optional<User> findById(Long id);

    @Query(value = "SELECT u.* FROM User u LEFT JOIN Role r ON u.role_id = r.id WHERE r.name NOT IN :roleNames", nativeQuery = true)
    List<User> findAllExceptRoles(@Param("roleNames") List<String> roleNames);

}
