package ru.job4j.oop;

public class Surgeon extends Doctor {

    public String name = "Майк ";

    public String surname = "Либовский ";

    public String education = "Магистр ";

    public String birthday = "29.03.1972 ";

    public void showInfo() {
        System.out.print(name);
        System.out.print(surname);
        System.out.print(education);
        System.out.println(birthday);
    }

    public void work() {
        System.out.println("Оперирует людей");
    }
}
