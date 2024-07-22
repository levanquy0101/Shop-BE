package com.example.shop.repositories;

import com.example.shop.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepo extends JpaRepository<Bill, Long> {
}
