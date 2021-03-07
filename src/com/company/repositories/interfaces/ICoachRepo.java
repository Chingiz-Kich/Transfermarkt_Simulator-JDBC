package com.company.repositories.interfaces;

import com.company.entities.Coach;

import java.util.List;

public interface ICoachRepo {
    List<Coach> getAllCoaches();        // в главнои меню
    Coach getInfoCoach(String surname);     // в главном меню (инфа о коаче)
    int getLicense(String surname);
    boolean setLicense(String surname, int license);    // в главном меню
    String getTeam(String surname);     // в главном меню
    boolean setTeam(String surname, String team);       // в трансферах при назначении гл. тренера
    // boolean teamHasCoach(String team);                  // в трасферах при назначении гл. тренера
    int sackingCoach(String team);                  // в трансферах
}
