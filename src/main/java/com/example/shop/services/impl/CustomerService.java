package com.example.shop.services.impl;

import com.example.shop.entities.Customer;
import com.example.shop.entities.CustomerLevel;
import com.example.shop.repositories.ICustomerLevelRepo;
import com.example.shop.repositories.ICustomerRepo;
import com.example.shop.services.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    private ICustomerRepo iCustomerRepo;
    @Autowired
    private ICustomerLevelRepo iCustomerLevelRepo;

    @Override
    public List<Customer> findAll() {
        return iCustomerRepo.findAll();
    }

    @Override
    public Customer save(Customer customer) {
        Optional<CustomerLevel> customerLevelOptional = iCustomerLevelRepo.findById(1L);
        if (customerLevelOptional.isPresent()) {
            customer.setCustomerLevel(customerLevelOptional.get());
            customer.setPoints(0);
            customer.setDate(LocalDate.now());
            return iCustomerRepo.save(customer);
        }
        customer.setPoints(0);
        customer.setDate(LocalDate.now());
        return iCustomerRepo.save(customer);
    }

    @Override
    public void update(Long id, Customer customer) {
        if (iCustomerRepo.existsById(id)) {
            iCustomerRepo.save(customer);
        }
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

    @Override
    public String generateEmployeeCode() {
        Long codeAuto = Optional.ofNullable(iCustomerRepo.findMaxId()).orElse(0L);
        return "KH-" + String.format("%03d", codeAuto + 1);
    }

}
