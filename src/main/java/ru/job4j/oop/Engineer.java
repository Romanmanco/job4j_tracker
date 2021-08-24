package ru.job4j.oop;

public class Engineer extends Profession{

    public Engineer(String name, String surname, String education, String birthday) {
    }

    public boolean canDoCode() {
        return true;
    }

    public boolean canBuildBilding() {
        return true;
    }

    public static void main(String[] args) {
        Engineer engineerProgrammer = new Engineer("Lary", "Jump", "Magister", "01/01");
        System.out.println(engineerProgrammer.canDoCode());
        Engineer engineerBuilder = new Engineer("Sarah", "Taylor", "Magister", "16/09");
        System.out.println(engineerBuilder.canBuildBilding());
    }
}
