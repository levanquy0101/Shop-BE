package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.News;
import org.springframework.data.repository.CrudRepository;

public interface INewsRepo extends CrudRepository<News, Long> {
}
