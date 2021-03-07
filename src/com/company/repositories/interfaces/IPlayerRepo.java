package com.company.repositories.interfaces;

import com.company.entities.Player;
import java.util.List;

public interface IPlayerRepo {
    boolean createTeamPlayer(Player player);    // в главном меню +
    boolean createFreePlayer(Player player);    // в главном меню +
    Player getInfoPlayer(String surname);       // в главном меню +
    boolean updateToCoach(String surname);      // в главном меню +
    boolean endCareer(String surname);          // в главном меню +
    boolean getAvailable(String surname);       // во время трансфера +
    boolean setAvailable(String surname, boolean available);       // фича в трансферах +
    boolean setPrice(String surname, int price);                   // фича в трансферах +
    int getPrice(String surname);               // во время трансфера +
    List<Player> getAllPlayers(String team);               // в главном меню +
    String getTeam(String surname);             // во время трансфера +
    boolean setTeam(String surname, String team);   // во время трансфера +
    int getAge(String surname);                 // во время назначиня тренером
}
