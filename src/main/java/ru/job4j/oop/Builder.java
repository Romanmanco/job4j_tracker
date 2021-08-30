package ru.job4j.oop;

public class Builder extends Engineer {

    public String name = "Пол ";

    public String surname = "Мичел ";

    public String education = "Магистр ";

    public String birthday = "25.01.1979 ";

    public void showInfo() {
        System.out.print(name);
        System.out.print(surname);
        System.out.print(education);
        System.out.println(birthday);
    }

    public void work() {
        System.out.println("Создает проекты городов");
    }
}
