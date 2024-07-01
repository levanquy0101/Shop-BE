package com.example.fashionshop.controllers;
import com.example.fashionshop.dto.ChangePasswordDTO;
import com.example.fashionshop.dto.UserDTO;
import com.example.fashionshop.entities.Customer;
import com.example.fashionshop.entities.User;
import com.example.fashionshop.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/user")
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("{username}")
    @ResponseBody
    public UserDTO getUserById(@PathVariable String username) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usernameAuthentication = authentication.getName();
        if (usernameAuthentication.equals(username)) {
            User user = iUserService.findByUsername(username);
            return iUserService.convertToDTO(user);
        }else {
            return null;
        }
    }

//    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_MANAGER')")
    @PostMapping("/create")
    public ResponseEntity<?> createUser(@RequestBody User user) {
        User createdUser = iUserService.save(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("{id}/change-password")
    public ResponseEntity<?> changePassword(@PathVariable Long id, @RequestBody ChangePasswordDTO changePasswordDTO) {
        User user = iUserService.findById(id);
        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usernameAuthentication = authentication.getName();
        if (!usernameAuthentication.equals(user.getUsername())) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        if (!passwordEncoder.matches(changePasswordDTO.getOldPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error: Current password is incorrect!");
        }
        user.setPassword(changePasswordDTO.getNewPassword());
        iUserService.save(user);
        return ResponseEntity.ok("Password changed successfully");
    }
}
