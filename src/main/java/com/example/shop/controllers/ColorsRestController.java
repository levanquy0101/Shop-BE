package com.example.shop.controllers;

import com.example.shop.entities.Colors;
import com.example.shop.services.IColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/auth/colors")
@CrossOrigin(origins = "*")
public class ColorsRestController {
    @Autowired
    private IColorsService iColorsService;

    @GetMapping("")
    public ResponseEntity<?> getAllColor() {
        List<Colors> colorsList = iColorsService.findAllColor();
        return new ResponseEntity<>(colorsList, HttpStatus.OK);
    }
}
