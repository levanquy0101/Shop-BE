package com.example.shop.services;

import com.example.shop.entities.TeamPromotion;

import java.util.List;

public interface ITeamPromotionService {

    List<TeamPromotion> findAll();

    TeamPromotion save(TeamPromotion team);

    TeamPromotion update(Long id, TeamPromotion team);

    void delete(Long id);
}
