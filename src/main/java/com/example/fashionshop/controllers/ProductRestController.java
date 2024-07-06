package com.example.fashionshop.controllers;

import com.example.fashionshop.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/product")
@CrossOrigin(origins = "*")
public class ProductRestController {
    @Autowired
    private IProductService iProductService;
//    @GetMapping("")
//    public ResponseEntity<?> getAllSize() {
//        List<Product> productList = iProductService.findAllProduct();
//        return new ResponseEntity<>(productList, HttpStatus.OK);
//    }

    @GetMapping("/code-auto")
    public ResponseEntity<?> getCodeAuto() {
        String codeAuto = iProductService.generateProductCode();
        return new ResponseEntity<>(codeAuto,HttpStatus.OK);
    }
}
