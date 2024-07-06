package com.example.fashionshop.controllers;

import com.example.fashionshop.entities.Role;
import com.example.fashionshop.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/auth/role")
@CrossOrigin(origins = "*")
public class RoleRestController {
    @Autowired
    private IRoleService iRoleService;

//    @GetMapping("")
//    public ResponseEntity<List<Role>> getAllRole() {
//        List<Role> roles = iRoleService.findAll();
//        return new ResponseEntity<>(roles, HttpStatus.OK);
//    }

    @GetMapping("/not")
    public ResponseEntity<List<Role>> getAllRoleNotIn() {
        List<String> names = Arrays.asList("ROLE_ADMIN", "ROLE_MANAGER");
        List<Role> roles = iRoleService.findByNameNotIn(names);
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }


//    @PostMapping("/create")
//    public ResponseEntity<Role> createRole(@RequestBody Role role) {
//        Role createdRole = iRoleService.create(role);
//        return new ResponseEntity<>(createdRole, HttpStatus.CREATED);
//    }

//    @PutMapping("/update/{id}")
//    public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role role) {
//        Role updatedRole = iRoleService.update(id, role);
//        return new ResponseEntity<>(updatedRole, HttpStatus.OK);
//    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
//        iRoleService.delete(id);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
}
