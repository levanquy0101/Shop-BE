package com.example.shop.repositories;

import com.example.shop.entities.ProductImage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductImageRepo extends JpaRepository<ProductImage, Long> {
}
