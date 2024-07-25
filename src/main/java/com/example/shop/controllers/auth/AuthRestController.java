package com.example.shop.controllers.auth;

import com.example.shop.dto.LoginRequest;
import com.example.shop.dto.LoginResponse;
import com.example.shop.dto.UserDTO;
import com.example.shop.jwt.JwtUtil;
import com.example.shop.services.IUserService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private AuthenticationManager authenticationManager;

    private final JwtUtil jwtUtil;

    @Autowired
    public AuthRestController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest, HttpServletRequest request, HttpServletResponse response) {
        try {
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                    loginRequest.getUsername(), loginRequest.getPassword());

            authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            Authentication authentication = authenticationManager.authenticate(authToken);

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // Tạo JWT
            String jwtToken = jwtUtil.generateToken(loginRequest.getUsername());

            // Thiết lập cookie HTTP-only
            Cookie cookie = new Cookie("token", jwtToken);
            cookie.setHttpOnly(true);
           // cookie.setSecure(true); // Chỉ gửi cookie qua HTTPS trong môi trường sản xuất
            cookie.setPath("/");
            cookie.setMaxAge(24 * 60 * 60); // Thời gian tồn tại của cookie (1 ngày)
            response.addCookie(cookie);

            String usernameAuthentication = authentication.getName();
            String rolesAuthentication = authentication.getAuthorities().toString();
            LoginResponse loginResponse = new LoginResponse("Login successful",usernameAuthentication,rolesAuthentication);
            return new ResponseEntity<>(loginResponse,HttpStatus.OK);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new LoginResponse("Invalid username or password", null,null));
        }
    }
}
