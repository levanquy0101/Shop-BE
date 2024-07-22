package com.example.shop.repositories;

import com.example.shop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderCustomerRepo extends JpaRepository<Customer, Long> {

}

