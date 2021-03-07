package com.company.controller;

import com.company.entities.Player;
import com.company.repositories.interfaces.IPlayerRepo;

import java.util.List;

/* Controller is a class for handling requests and returning results directly.*/

public class playerController {
    private final IPlayerRepo repo;

    public playerController(IPlayerRepo repo) {
        this.repo = repo;
    }

    public String createTeamPlayer(Player player) {
        boolean create = this.repo.createTeamPlayer(player);
        return create ? "The young talent " + player.getName() +
                "was joined to " + player.getTeam() + "!" :
                "Something goes wrong...Please check input data and try again.";
    }

    public String createFreePlayer(Player player) {
        boolean create = this.repo.createFreePlayer(player);
        return create ? "The young talent  " + player.getName() + " became a free player!" :
                "Something goes wrong...Please check input data and try again.";
    }

    public String getInfoPlayer(String surname) {
        Player getInfo = this.repo.getInfoPlayer(surname);
        return getInfo.getAllInfo();
    }

    public String updateToCoach(String surname) {
        boolean update = this.repo.updateToCoach(surname);
        return update ? "BREAKING NEWS!!!\n" + surname + " get a coach license!" :
                "Something goes wrong...Please check input data and try again.";
    }

    public String endCareer(String surname) {
        boolean end = this.repo.endCareer(surname);
        return end ? "BREAKING NEWS!!!\n" + surname + " end football career!" :
                "Something goes wrong...Please check input data and try again.";
    }

    public String setAvailable(String surname, boolean available) {
        boolean setAvailable = this.repo.setAvailable(surname, available);
        return setAvailable ? "Operation was successful!" :
                "Operation was successful!";
    }

    public String setPrice(String surname, int price) {
        boolean setPrice = this.repo.setPrice(surname, price);
        return surname + "'s price changed.";
    }

    public int getPrice(String surname) {
        return this.repo.getPrice(surname);             // Тут мы вытаскиваем информацию из базы данных
    }

    // Во всех остальных случаях, где метод возвращает Стринг ->
    // Мы заносим инормацию в базу данных - в репозитории они возвращают булевое значение

    public String getAllPlayers(String team) {
        List<Player> players = this.repo.getAllPlayers(team);
        return players.toString();
    }

    public String getTeam(String surname) {
        return this.repo.getTeam(surname);
    }

    public String setTeam(String surname, String team) {
        boolean setTeam = this.repo.setTeam(surname, team);
        return setTeam ? "BREAKING NEWS!!!\n" + surname + " joined to " +
                team + "!" : "Something goes wrong...Please check input data and try again.";
    }

    public boolean getAvailable(String surname) {
        return this.repo.getAvailable(surname);
    }

    public int getAge(String surname) {
        return this.repo.getAge(surname);
    }
}
