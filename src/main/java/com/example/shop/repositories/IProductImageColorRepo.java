package com.example.shop.repositories;

import com.example.shop.entities.ProductImageColor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductImageColorRepo extends JpaRepository<ProductImageColor, Long> {
}
