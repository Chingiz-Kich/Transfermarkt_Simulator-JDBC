package com.company.controller;

import com.company.entities.Coach;
import com.company.repositories.interfaces.IClubRepo;
import com.company.repositories.interfaces.ICoachRepo;

import java.util.List;

/* Controller is a class for handling requests and returning results directly.*/

public class coachController {
    private final ICoachRepo repo;
    private final IClubRepo repoClub;

    public coachController(ICoachRepo repo, IClubRepo repoClub) {
        this.repo = repo;
        this.repoClub = repoClub;
    }

    public String getAllCoaches() {
        List<Coach> coaches = this.repo.getAllCoaches();
        return coaches.toString();
    }

    public String getInfoCoach(String surname) {
        Coach coach = this.repo.getInfoCoach(surname);
        return coach.getAllInfo();
    }

    public String setLicense(String surname, int license) {
        boolean setLicense = this.repo.setLicense(surname, license);
        return setLicense ? "Coach " + surname + "'s license was updated." +
                "\nNew license has " + license + " level." :
                "Something goes wrong...Please check input data and try again.";
    }

    public String getTeam (String surname) {
        return surname + " coach of " + this.repo.getTeam(surname) +
                " football club.";
    }

    public String setTeam(String surname, String team) {
        int license = this.repo.getLicense(surname);
        int level = this.repoClub.getLevel(team);
        if (license >= level) {
            boolean setTeam = this.repo.setTeam(surname, team);
            return setTeam ? "BREAKING NEWS!\n" + surname + " appointed " +
                    team + " head coach!" :
                    "Something goes wrong...Please check input data and try again.";
        } else {
            return "IMPOSSIBLE. " + surname + "'s license is not satisfied the " +
                    "requirement to lead " + team + " club of this level.";
        }

    }

    /* public boolean teamHasCoach(String team) {
        return this.repo.teamHasCoach(team);
    } */

    public String sackingCoach(String team) {
        int sack = this.repo.sackingCoach(team);
        return sack > 0 ? team + " sacked his head coach!" : "Something goes wrong...Please check input data and try again.";
    }
}
