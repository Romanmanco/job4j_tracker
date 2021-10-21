package ru.job4j.oop;

public class Doctor extends Profession {

    private String heal;

    public Doctor(String name, String surname, String education, String birthday, String heal) {
        super(name, surname, education, birthday);
        this.heal = heal;
    }
}
