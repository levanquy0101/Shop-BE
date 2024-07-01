package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBillRepo extends JpaRepository<Bill, Long> {
}
