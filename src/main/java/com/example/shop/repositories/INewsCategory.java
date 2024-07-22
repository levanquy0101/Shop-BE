package com.example.shop.repositories;

import com.example.shop.entities.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsCategory extends JpaRepository<NewsCategory, Long> {
}
