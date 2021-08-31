package ru.job4j.oop;

public class Engineer extends Profession {

    public String workAtProject;

    public Engineer(String name, String surname, String education, String birthday, String workAtProject) {
        super(name, surname, education, birthday);
        this.workAtProject = workAtProject;
    }
}
