package com.example.fashionshop.controllers;

import com.example.fashionshop.entities.Sizes;
import com.example.fashionshop.services.ISizeService;
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
