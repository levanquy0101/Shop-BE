package com.example.shop.services.impl;

import com.example.shop.entities.TeamPromotion;
import com.example.shop.repositories.ITeamPromotionRepo;
import com.example.shop.services.ITeamPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamPromotionService implements ITeamPromotionService {
    @Autowired
    private ITeamPromotionRepo iTeamPromotionRepo;

    @Override
    public List<TeamPromotion> findAll() {
        return iTeamPromotionRepo.findAll();
    }

    @Override
    public TeamPromotion save(TeamPromotion team) {
        return iTeamPromotionRepo.save(team);
    }

    @Override
    public TeamPromotion update(Long id, TeamPromotion team) {
        if (iTeamPromotionRepo.existsById(id)) {
            return iTeamPromotionRepo.save(team);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
        if (iTeamPromotionRepo.existsById(id)) {
            iTeamPromotionRepo.deleteById(id);
        }
        else {
            System.out.println("Không thể xóa đối tượng");
        }
    }
}
