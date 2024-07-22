package com.example.shop.services.impl;

import com.example.shop.repositories.IProductRepo;
import com.example.shop.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public String generateProductCode() {
        Long codeAuto = Optional.ofNullable(iProductRepo.findMaxId()).orElse(0L);
        return "SP-" + String.format("%03d", codeAuto + 1);
    }
}
