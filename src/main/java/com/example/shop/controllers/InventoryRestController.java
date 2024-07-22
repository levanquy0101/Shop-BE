package com.example.shop.controllers;

import com.example.shop.dto.InventoryDTO;
import com.example.shop.services.IInventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/inventory")
@CrossOrigin(origins = "*")
public class InventoryRestController {
    @Autowired
    private IInventoryService iInventoryService;

    @PostMapping("/create")
    public ResponseEntity<?> createInventory(@RequestBody InventoryDTO inventoryDTO) {
        System.out.println(inventoryDTO);
        iInventoryService.createInventory(inventoryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

