package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailRepo extends JpaRepository<OrderDetail, Long> {
}
