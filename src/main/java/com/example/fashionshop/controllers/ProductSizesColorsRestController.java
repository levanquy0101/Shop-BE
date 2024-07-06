package com.example.fashionshop.controllers;

import com.example.fashionshop.dto.ProductSizesColorsDTO;
import com.example.fashionshop.entities.ProductSizesColors;
import com.example.fashionshop.services.IProductSizesColorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/product-size-color")
@CrossOrigin(origins = "*")
public class ProductSizesColorsRestController {
    @Autowired
    private IProductSizesColorsService iProductSizesColorsService;
//    @GetMapping("")
//    public ResponseEntity<?> getAllProductSizesColors() {
//        List<ProductSizesColors> productSizesColorsList = iProductSizesColorsService.findAllProductSizesColors();
//        return new ResponseEntity<>(productSizesColorsList, HttpStatus.OK);
//    }

    @GetMapping("")
    public ResponseEntity<?> getAllProductSizesColors(@RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "10") int size) {
        Page<ProductSizesColors> productSizesColorsPage = iProductSizesColorsService.getProductSizesColors(page,size );
        return new ResponseEntity<>(productSizesColorsPage, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<?> createProductSizesColors(@RequestBody ProductSizesColorsDTO productSizesColorsDTO){
        iProductSizesColorsService.createProductSizesColors(productSizesColorsDTO);
        System.out.println(productSizesColorsDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);

    }

    @GetMapping("{code}")
    public ResponseEntity<?> getProductSizesColors(@PathVariable String code){
        ProductSizesColors productSizesColors = iProductSizesColorsService.findByCode(code);
        if(productSizesColors == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productSizesColors, HttpStatus.OK);
    }
}
