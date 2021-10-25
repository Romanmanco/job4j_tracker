package ru.job4j.oop;

public class Programmer extends Engineer {

    private String doCode;

    public Programmer(String name, String surname, String education, String birthday, String work, String doCode) {
        super(name, surname, education, birthday, work);
        this.doCode = doCode;
    }
}
