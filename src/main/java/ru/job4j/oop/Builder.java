package ru.job4j.oop;

public class Builder extends Engineer {

    private String doBuilding;

    public Builder(String name, String surname, String education, String birthday,
                   String workAtProject, String doBuilding) {
        super(name, surname, education, birthday, workAtProject);
        this.doBuilding = doBuilding;
    }
}
