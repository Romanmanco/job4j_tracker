package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Aртур ");
        student.setSurname("Пирожков ");
        student.setPatronymic("Аристархович ");
        student.setGroup("Стажер ");
        student.setCreated(new Date());

        System.out.println("Студент ФИО: " + student.getName() + student.getSurname() + student.getPatronymic() +
                System.lineSeparator() + "Группа и дата поступления: " + student.getGroup() + student.getCreated());
    }
}
