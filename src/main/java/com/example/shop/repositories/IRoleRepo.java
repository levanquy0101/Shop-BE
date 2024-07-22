package com.example.shop.repositories;

import com.example.shop.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IRoleRepo extends JpaRepository<Role, Long> {
//    boolean existByName(String name);
    Role findByName(String name);

    @Query("SELECT r FROM Role r WHERE r.name NOT IN :names")
    List<Role> findByNameNotIn(List<String> names);
}
