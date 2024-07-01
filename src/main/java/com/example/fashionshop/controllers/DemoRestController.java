//package com.example.fashionshop.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/levanquy")
//@CrossOrigin(origins = "*")
//public class DemoFastRestController {
//    @Autowired
//    private IDemoFastService iDemoFastService;
//
//    @GetMapping("")
//    public ResponseEntity<List<DemoFast>> getAllDemoFast() {
//        List<DemoFast> levanquys = iDemoFastService.findAll();
//        return new ResponseEntity<>(levanquys, HttpStatus.OK);
//    }
//
//    @PostMapping("/create")
//    public ResponseEntity<DemoFast> createDemoFast(@RequestBody DemoFast levanquy) {
//        DemoFast createdDemoFast = iDemoFastService.create(levanquy);
//        return new ResponseEntity<>(createdDemoFast, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/update/{id}")
//    public ResponseEntity<DemoFast> updateDemoFast(@PathVariable Long id, @RequestBody DemoFast levanquy) {
//        DemoFast updatedDemoFast = iDemoFastService.update(id, levanquy);
//        return new ResponseEntity<>(updatedDemoFast, HttpStatus.OK);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteDemoFast(@PathVariable Long id) {
//        iDemoFastService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//}
