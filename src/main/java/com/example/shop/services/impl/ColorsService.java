package com.example.shop.services.impl;

import com.example.shop.entities.Colors;
import com.example.shop.repositories.IColorsRepo;
import com.example.shop.services.IColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorsService implements IColorsService {
    @Autowired
    private IColorsRepo iColorsRepo;

    @Override
    public List<Colors> findAllColor() {
        return iColorsRepo.findAll();
    }
}
