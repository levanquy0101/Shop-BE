package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISizeRepo extends JpaRepository<Sizes, Long> {
}
