package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public void went() {

    }

    @Override
    public void passenger(int numPas) {

    }

    @Override
    public int refuel(int oilValue, int oilPrice) {
        return oilPrice;
    }
}
