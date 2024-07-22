package com.example.shop.repositories;

import com.example.shop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {

    @Query("SELECT MAX(c.id) FROM Customer c")
    Long findMaxId();
}
