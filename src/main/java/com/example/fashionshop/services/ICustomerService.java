package com.example.fashionshop.services;

import com.example.fashionshop.entities.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Customer save(Customer customer);

    void update(Long id, Customer customer);

    void delete(Long id);

    String generateEmployeeCode();
}
