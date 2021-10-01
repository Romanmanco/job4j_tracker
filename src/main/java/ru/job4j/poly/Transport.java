package ru.job4j.poly;

public interface Transport {
    void went();

    void passenger(int numPas);

    int refuel(int oilValue, int oilPrice);
}
