package com.example.shop.repositories;

import com.example.shop.entities.TeamPromotion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITeamPromotionRepo extends JpaRepository<TeamPromotion,Long> {
}
