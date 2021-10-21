package ru.job4j.oop;

public class Dentist extends Doctor {

    private String healTooth;

    public Dentist(String name, String surname, String education, String birthday, String heal, String healTooth) {
        super(name, surname, education, birthday, heal);
        this.healTooth = healTooth;
    }
}
