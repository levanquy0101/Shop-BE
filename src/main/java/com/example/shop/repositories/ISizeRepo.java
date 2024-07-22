package com.example.shop.repositories;

import com.example.shop.entities.Sizes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISizeRepo extends JpaRepository<Sizes, Long> {
}
