package ru.job4j.oop;

public class Profession {

    public String name;

    public String surname;

    public String education;

    public String birthday;

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon();
        surgeon.showInfo();
        surgeon.work();
        Dentist dentist = new Dentist();
        dentist.showInfo();
        dentist.work();
        Programmer programmer = new Programmer();
        programmer.showInfo();
        programmer.work();
        Builder builder = new Builder();
        builder.showInfo();
        builder.work();
    }
}
