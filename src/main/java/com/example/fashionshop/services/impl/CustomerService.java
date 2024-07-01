package com.example.fashionshop.services.impl;

import com.example.fashionshop.entities.Customer;
import com.example.fashionshop.entities.CustomerLevel;
import com.example.fashionshop.repositories.ICustomerRepo;
import com.example.fashionshop.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        customer.setCustomerLevel(new CustomerLevel(1L,""));
        customer.setPoints(0);
        customer.setDate(LocalDate.now());
        return iCustomerRepo.save(customer);
    }

    @Override
    public Customer update(Long id, Customer customer) {
        if (iCustomerRepo.existsById(id)) {
            return iCustomerRepo.save(customer);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (iCustomerRepo.existsById(id)) {
            iCustomerRepo.deleteById(id);
        }
        else {
            System.out.println("Không thể xóa đối tượng");
        }
    }

}
