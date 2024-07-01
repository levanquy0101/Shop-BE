package com.example.fashionshop.repositories;

import com.example.fashionshop.entities.Report;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReportRepo extends JpaRepository<Report, Long> {
}
