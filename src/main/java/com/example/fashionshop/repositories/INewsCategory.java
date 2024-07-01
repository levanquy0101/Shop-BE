package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsCategory extends JpaRepository<NewsCategory, Long> {
}
