package com.company.controller;

import com.company.repositories.interfaces.IClubRepo;
import com.company.entities.Club;

import java.util.List;

/* Controller is a class for handling requests and returning results directly.*/

public class clubController {
    private final IClubRepo repo;

    public clubController(IClubRepo repo) {
        this.repo = repo;
    }

    public String infoAboutClub(String name) {
        Club club = this.repo.infoAboutClub(name);
        return club.getInfo();
    }

    public String updateBudget(String name, int budget) {
        boolean upBudget = this.repo.updateBudget(name, budget);
        return upBudget ? "Money accounting...Successful." : "Something goes wrong\nCheck budget of the club";
    }

    public int getBudget(String name) {
        int budget = this.repo.getBudget(name);
        return budget;
    }

    public int getClubByPlayersPrice(String name) {
        int sum = this.repo.getClubByPlayersPrice(name);
        return sum;
    }

    public String getAllClubs() {
        List<Club> clubs = this.repo.getAllClubs();
        return clubs.toString();
    }
}
