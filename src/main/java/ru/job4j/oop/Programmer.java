package ru.job4j.oop;

public class Programmer extends Engineer {

    public String name = "Лари ";

    public String surname = "Кинг ";

    public String education = "Магистр ";

    public String birthday = "01.09.1989 ";

    public void showInfo() {
        System.out.print(name);
        System.out.print(surname);
        System.out.print(education);
        System.out.println(birthday);
    }

    public void work() {
        System.out.println("Создает программное обеспечение");
    }
}
