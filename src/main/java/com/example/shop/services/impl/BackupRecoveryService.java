package com.example.shop.services.impl;

import com.example.shop.ShopApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service

public class BackupRecoveryService {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private ConfigurableApplicationContext context;
    public void resetSystem() {
        jdbcTemplate.execute("drop database `fashion-demo`;");
        restartApplication();
    }
    private void restartApplication() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
                context.close();
                SpringApplication.run(ShopApplication.class);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.setDaemon(false);
        thread.start();
    }
}
