package com.company.repositories.interfaces;

import com.company.entities.Club;

import java.util.List;

public interface IClubRepo {
    Club infoAboutClub (String name);        // в клубе
    boolean updateBudget(String name, int budget);      // во время трансфера игрока
    int getBudget(String name);               // во время трансфера игрока
    int getClubByPlayersPrice(String name);     // в главном меню
    int getLevel(String name);                // во время назначения тренера
    List<Club> getAllClubs();                   // в главном меню
}
