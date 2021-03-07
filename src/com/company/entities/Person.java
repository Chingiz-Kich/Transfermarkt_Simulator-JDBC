package com.company.entities;

// Person class was created to be inherited by the "player" and "coach" classes

public class Person {
    private String name;
    private String surname;
    private String nationality;
    private int age;
    private String team;

    public Person(){};

    public Person(String name, String surname, String nationality, int age, String team) {
        this.name = name;
        this.surname = surname;
        this.nationality = nationality;
        this.age = age;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
}
