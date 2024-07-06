package com.example.fashionshop.services.impl;

import com.example.fashionshop.entities.Colors;
import com.example.fashionshop.repositories.IColorsRepo;
import com.example.fashionshop.services.IColorsService;
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
