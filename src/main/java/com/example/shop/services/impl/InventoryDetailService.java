package com.example.shop.services.impl;

import com.example.shop.repositories.IInventoryDetailRepo;
import com.example.shop.services.IInventoryDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryDetailService implements IInventoryDetailService {
    @Autowired
    private IInventoryDetailRepo iInventoryDetailRepo;
}
