package com.example.shop.repositories;

import com.example.shop.entities.News;
import org.springframework.data.repository.CrudRepository;

public interface INewsRepo extends CrudRepository<News, Long> {
}
