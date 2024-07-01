package com.example.fashionshop.controllers;

import com.example.fashionshop.services.impl.BackupRecoveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/backup-recovery")
@CrossOrigin(origins = "*")
public class BackupRecoveryRestController {
    @Autowired
    private BackupRecoveryService backupRecoveryService;

    @PostMapping("/reset")
    public ResponseEntity<?> ResetSystem() {
        try {
            backupRecoveryService.resetSystem();
            return ResponseEntity.ok("Khôi phục cài đặt gốc thành công !");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Khôi phục cài đặt gốc thất bại: " + e.getMessage());
        }
    }
}

