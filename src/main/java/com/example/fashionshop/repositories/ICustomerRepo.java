package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepo extends JpaRepository<Customer, Long> {

}
