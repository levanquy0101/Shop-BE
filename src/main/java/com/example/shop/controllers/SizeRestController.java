package com.example.shop.controllers;

import com.example.shop.entities.Sizes;
import com.example.shop.services.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth/sizes")
@CrossOrigin(origins = "*")
public class SizeRestController {
    @Autowired
    private ISizeService iSizeService;

    @GetMapping("")
    public ResponseEntity<?> getAllSize() {
        List<Sizes> sizeList = iSizeService.findAllSize();
        return new ResponseEntity<>(sizeList, HttpStatus.OK);
    }
}
