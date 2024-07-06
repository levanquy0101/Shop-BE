package com.example.fashionshop.controllers;

import com.example.fashionshop.entities.Customer;
import com.example.fashionshop.entities.User;
import com.example.fashionshop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/auth/employee")
@CrossOrigin(origins = "*")
public class EmployeeRestController {
    @Autowired
    private IUserService iUserService;

    @GetMapping("")
    public ResponseEntity<?> getAllEmployees() {
        List<String> names = Arrays.asList("ROLE_ADMIN", "ROLE_MANAGER");
        List<User> userList = iUserService.findAllEmployeeExceptRoles(names);
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<?> getEmployeeById(@PathVariable Long id){
        User user = iUserService.findById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable Long id, @RequestBody User user ) {
        iUserService.update(id, user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        iUserService.deleteEmployee(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
