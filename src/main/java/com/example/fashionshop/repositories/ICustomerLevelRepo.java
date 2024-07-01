package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.CustomerLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerLevelRepo extends JpaRepository<CustomerLevel, Long> {
}
