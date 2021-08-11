package ru.job4j.oop;

public class Student {

    public void music(String lyrics) {
        System.out.println("I can sing a song : " + lyrics);
    }

    public void song() {
        System.out.println("I belive i can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        String song = "I belive i can fly";
        petya.music(song);
    }
}
