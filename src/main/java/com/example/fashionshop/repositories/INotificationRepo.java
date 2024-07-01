package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Notification;
import org.springframework.data.repository.CrudRepository;

public interface INotificationRepo extends CrudRepository<Notification, Long> {
}
