package com.example.shop.services;

import com.example.shop.entities.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> findAll();

    Customer save(Customer customer);

    void update(Long id, Customer customer);

    void delete(Long id);

    String generateEmployeeCode();
}
