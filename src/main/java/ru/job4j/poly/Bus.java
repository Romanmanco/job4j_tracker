package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void went() {
        System.out.println("Автобус едет в Краснодар.");
    }

    @Override
    public void passenger(int numPas) {
    }

    @Override
    public int refuel(int oilValue, int oilPrice) {
        return oilValue;
    }

    @Override
    public void move() {
        System.out.println("Автобус едет.");
    }
}
