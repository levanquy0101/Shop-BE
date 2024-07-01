package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserNotificationRepo extends JpaRepository<UserNotification, Long> {
}
