package ru.job4j.oop;

public class Dentist extends Doctor {

    public String name = "Стивин ";

    public String surname = "Сигал ";

    public String education = "Магистр ";

    public String birthday = "11.07.1967 ";

    public void showInfo() {
        System.out.print(name);
        System.out.print(surname);
        System.out.print(education);
        System.out.println(birthday);
    }

    public void work() {
        System.out.println("Лечит зубы людей");
    }
}
