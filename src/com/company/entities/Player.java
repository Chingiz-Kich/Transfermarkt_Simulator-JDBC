package com.company.entities;

/*
* Player class contains all entities from database and methods which we use while doing actions with our applications
* */

public class Player extends Person {
    private String position;
    private int price;
    private boolean available;

    public Player(){};

    public Player(String name, String surname, String nationality, int age, String position, int price, boolean available, String team, boolean isPlayer) {
        super(name, surname, nationality, age, team);
        this.position = position;
        this.price = price;
        this.available = available;
    }

    //FOR getPlayer
    public Player(String name, String surname, String nationality, int age, String position, int price, boolean available, String team) {
        super(name, surname, nationality, age, team);
        this.position = position;
        this.price = price;
        this.available = available;
    }

    // FOR updateToCoach
    public Player(String name, String surname, String nationality, int age, String team) {
        super(name, surname, nationality, age, team);
    }


    //FOR getAll Players
    public Player(String name, String surname) {
        super.setName(name);
        super.setSurname(surname);
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }


    public String getAvailable() {
        return isAvailable() ? "available" : "not available";
    }

    public String getAllInfo() {
        return "Player: \nName: " + getName() + "\nSurname: " + getSurname() +
                "\nNationality: " + getNationality() + "\nAge: " + getAge() +
                "\nPosition: " + getPosition() + "\nPrice: " + getPrice() + "$" +
                "\nTeam: " + getTeam() + "\nAvailability: " + getAvailable() + "\n";
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + "\n";
    }
}