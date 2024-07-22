package com.example.shop.repositories;

import com.example.shop.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepo extends JpaRepository<Report, Long> {
}
