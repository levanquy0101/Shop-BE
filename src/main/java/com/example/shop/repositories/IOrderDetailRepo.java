package com.example.shop.repositories;

import com.example.shop.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepo extends JpaRepository<OrderDetail, Long> {
}
