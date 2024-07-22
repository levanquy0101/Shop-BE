package com.example.shop.repositories;

import com.example.shop.entities.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserNotificationRepo extends JpaRepository<UserNotification, Long> {
}
