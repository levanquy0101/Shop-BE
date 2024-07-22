package com.example.shop.repositories;

import com.example.shop.entities.Colors;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IColorsRepo extends JpaRepository<Colors, Long> {
}
