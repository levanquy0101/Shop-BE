package com.example.shop.repositories;

import com.example.shop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IProductRepo extends JpaRepository<Product, Long> {
    @Query("SELECT MAX(p.id) FROM Product p")
    Long findMaxId();

    Product findByCode(String code);
}
