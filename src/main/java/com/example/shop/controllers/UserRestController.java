package com.example.shop.controllers;
import com.example.shop.dto.ChangePasswordDTO;
import com.example.shop.dto.UserDTO;
import com.example.shop.dto.UserInforUserDetails;
import com.example.shop.entities.Role;
import com.example.shop.entities.User;
import com.example.shop.services.IRoleService;
import com.example.shop.services.IUserService;
import com.nimbusds.openid.connect.sdk.claims.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/auth/user")
@CrossOrigin(origins = "*")
public class UserRestController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/user-info")
    public ResponseEntity<?> getUserInfo() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usernameAuthentication = authentication.getName();
        String rolesAuthentication = authentication.getAuthorities().toString();
        return ResponseEntity.ok(new UserDTO(usernameAuthentication, rolesAuthentication));
    }

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
    @GetMapping("/code-auto")
    public ResponseEntity<?> getAllRoleNotInAndAutoCode() {
        String codeAuto = iUserService.generateEmployeeCode();
        List<String> names = Arrays.asList("ROLE_ADMIN", "ROLE_MANAGER");
        List<Role> roles = iRoleService.findByNameNotIn(names);
        Map<String, Object> response = new HashMap<>();
        response.put("codeAuto", codeAuto);
        response.put("roles", roles);
        return new ResponseEntity<>(response, HttpStatus.OK);
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
