package com.example.shop.repositories;

import com.example.shop.entities.InventoryDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventoryDetailRepo extends JpaRepository<InventoryDetail, Long> {
}
