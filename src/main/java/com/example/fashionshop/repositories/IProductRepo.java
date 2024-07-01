package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductRepo extends JpaRepository<Product, Long> {
}
