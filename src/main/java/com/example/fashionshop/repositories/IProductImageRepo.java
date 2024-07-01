package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductImageRepo extends JpaRepository<ProductImage, Long> {
}
