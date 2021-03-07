package com.company;

import com.company.controller.clubController;
import com.company.controller.coachController;
import com.company.controller.playerController;
import com.company.data.IDB;
import com.company.data.PostgreDB;
import com.company.repositories.ClubRepo;
import com.company.repositories.CoachRepo;
import com.company.repositories.PlayerRepo;
import com.company.repositories.interfaces.IClubRepo;
import com.company.repositories.interfaces.ICoachRepo;
import com.company.repositories.interfaces.IPlayerRepo;


/*
* Main class connects data from the required packages and launches our application
* */


public class Main {

    public static void main(String[] args) {
        IDB db = new PostgreDB();
        IClubRepo clubRepo = new ClubRepo(db);
        IPlayerRepo playerRepo = new PlayerRepo(db);
        ICoachRepo coachRepo = new CoachRepo(db);
        clubController clubController = new clubController(clubRepo);
        playerController  playerController = new playerController(playerRepo);
        coachController coachController = new coachController(coachRepo, clubRepo);
        Application app = new Application(clubController, playerController, coachController);
        app.start();
    }
}
