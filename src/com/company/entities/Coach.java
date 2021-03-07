package com.company.entities;

/*
 * Coach class contains all entities from database and methods
 * which we use while doing actions with our applications
 * */


public class Coach extends Person {
    private int license;

    public Coach(String name, String surname, String nationality, int age, String team) {
        super(name, surname, nationality, age, team);
    }

    public Coach(String name, String surname, String nationality, int age, int license, String team) {
        super(name, surname, nationality, age, team);
        this.license = license;
    }

    public Coach(String name, String surname) {
        super.setName(name);
        super.setSurname(surname);
    }

    public Coach() {

    }

    public int getLicense() {
        return license;
    }

    public void setLicense(int license) {
        this.license = license;
    }

    public String getAllInfo() {
        return "Coach: \n" + "Name: " + getName() + "\nSurname: " +
                getSurname() + "\nAge: " + getAge() + "\nNationality: " +
                getNationality() + "\nLicense: " + getLicense() +
                "\nTeam: " + getTeam() + "\n";
    }

    @Override
    public String toString() {
        return getName() + " " + getSurname() + "\n";
    }
}
