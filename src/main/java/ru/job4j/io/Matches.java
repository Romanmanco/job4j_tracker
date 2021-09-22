package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Игра 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "Первый игрок" : "Второй игрок";
            System.out.println(player + " введите число от 1 до 3:");
            int matches = Integer.parseInt(input.nextLine());
            turn = !turn;

            switch (matches) {
                case 1 -> {
                    int value = count - 1;
                    count = value;
                    System.out.println(value);
                }
                case 2 -> {
                    int value = count - 2;
                    count = value;
                    System.out.println(value);

                }
                case 3 -> {
                    int value = count - 3;
                    count = value;
                    System.out.println(value);
                }
                default -> System.out.println("Введено неверное число");
            }
        }
        if (!turn) {
            System.out.println("Выиграл первый игрок");
        } else {
            System.out.println("Выиграл второй игрок");
        }
    }
}