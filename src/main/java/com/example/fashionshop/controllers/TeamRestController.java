package com.example.fashionshop.controllers;

import com.example.fashionshop.entities.TeamPromotion;
import com.example.fashionshop.services.ITeamPromotionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/auth/team")
@CrossOrigin(origins = "*")
public class TeamRestController {
    @Autowired
    private ITeamPromotionService iTeamService;
    @GetMapping("")
    @ResponseBody
    public List<TeamPromotion> getAll() {
        return iTeamService.findAll();
    }

    @PostMapping("/create")
    @ResponseBody
    public TeamPromotion createTeam(@RequestBody TeamPromotion team) {
        return iTeamService.save(team);
    }
    @PutMapping("/update/{id}")
    @ResponseBody
    public TeamPromotion updateTeam(@PathVariable Long id, @RequestBody TeamPromotion team) {
        return iTeamService.update(id, team);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public void deleteTeam(@PathVariable Long id) {
        iTeamService.delete(id);
    }
}

