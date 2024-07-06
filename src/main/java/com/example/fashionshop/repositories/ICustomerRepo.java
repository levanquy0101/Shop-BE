package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {

    @Query("SELECT MAX(c.id) FROM Customer c")
    Long findMaxId();
}
