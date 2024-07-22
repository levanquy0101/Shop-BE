package com.example.shop.repositories;

import com.example.shop.entities.CustomerLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerLevelRepo extends JpaRepository<CustomerLevel, Long> {
}
