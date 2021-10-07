package ru.job4j.poly;

public class Bus implements Transport, Vehicle {

    @Override
    public void went() {
        System.out.println("Автобус едет в краснодар.");
    }

    @Override
    public void passenger(int numPas) {
        passenger(24);
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
