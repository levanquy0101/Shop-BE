package com.example.shop.services.impl;

import com.example.shop.entities.Sizes;
import com.example.shop.repositories.ISizeRepo;
import com.example.shop.services.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SizeService implements ISizeService {
    @Autowired
    private ISizeRepo iSizeRepo;

    @Override
    public List<Sizes> findAllSize() {
        return iSizeRepo.findAll();
    }
}
