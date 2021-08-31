package ru.job4j.oop;

public class Surgeon extends Doctor {

    public String healPeople;

    public Surgeon(String name, String surname, String education, String birthday, String heal, String healPeople) {
        super(name, surname, education, birthday, heal);
        this.healPeople = healPeople;
    }
}
