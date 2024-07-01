package com.example.fashionshop.services;

import com.example.fashionshop.entities.TeamPromotion;

import java.util.List;

public interface ITeamPromotionService {

    List<TeamPromotion> findAll();

    TeamPromotion save(TeamPromotion team);

    TeamPromotion update(Long id, TeamPromotion team);

    void delete(Long id);
}
