package com.example.shop.repositories;

import com.example.shop.entities.Notification;
import org.springframework.data.repository.CrudRepository;

public interface INotificationRepo extends CrudRepository<Notification, Long> {
}
