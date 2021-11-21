package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public double add(double first, double second) {
        return first + second;
    }

    public double add(double first, double second, double third) {
        return add(
                first,
                add(second, third)
        );
    }

    public static int sum(int y) {
        return x + y;
    }

    public static int minus(int y) {
        return y - x;
    }

    public int multiply(int a) {
        return x * a;
    }

    public int divide(int a) {
        return a / x;
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        int result1 = minus(56);
        System.out.println(result1);
        Calculator calculator = new Calculator();
        int multiply = calculator.multiply(5);
        int divide = calculator.divide(5);
        System.out.println(multiply);
        System.out.println(divide);
    }
}
