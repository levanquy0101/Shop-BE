package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Size;
import org.springframework.data.repository.CrudRepository;

public interface ISizeRepo extends CrudRepository<Size, Long> {
}
