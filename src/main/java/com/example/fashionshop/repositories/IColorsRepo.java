package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Colors;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IColorsRepo extends JpaRepository<Colors, Long> {
}
