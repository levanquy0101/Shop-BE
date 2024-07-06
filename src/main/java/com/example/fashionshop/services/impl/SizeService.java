package com.example.fashionshop.services.impl;

import com.example.fashionshop.entities.Sizes;
import com.example.fashionshop.repositories.ISizeRepo;
import com.example.fashionshop.services.ISizeService;
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
