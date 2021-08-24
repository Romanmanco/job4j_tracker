package ru.job4j.oop;

public class Doctor extends Profession{

    public Doctor(String name, String surname, String education, String birthday) {
    }

    public boolean canKeepTooth() {
        return true;
    }

    public boolean Diagnosis() {
        return true;
    }

    public static void main(String[] args) {
        Doctor doctorDentist = new Doctor("Piter", "Trump", "Magister", "12/01");
        System.out.println(doctorDentist.canKeepTooth());
        Doctor doctorSurgeon = new Doctor("Jack", "Thomson", "Magister", "21/07");
        System.out.println(doctorSurgeon.Diagnosis());
    }
}
