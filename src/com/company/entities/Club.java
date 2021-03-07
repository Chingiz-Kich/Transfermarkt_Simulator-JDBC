package com.company.entities;

/*
* Coach class contains all entities from database and methods
* which we use while doing actions with our applications
* */

public class Club {
    private String name;
    private String country;
    private String league;
    private int budget;
    private int level;

    public Club() {};

    public Club(String name, String country, String league, int budget) {
        this.name = name;
        this.country = country;
        this.league = league;
        this.budget = budget;
    }

    public Club(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLeague() {
        return league;
    }

    public void setLeague(String league) {
        this.league = league;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getInfo() {
        return "\nClub name: " + getName() + "\nCountry: " + getCountry() +
                "\nLeague: " + getLeague() + "\nBudget for transfers: " +
                getBudget() + "$";
    }

    @Override
    public String toString() {
        return "\nClub: " + getName();
    }
}
