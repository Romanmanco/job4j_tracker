package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.ex.Fact;

public class FactTest {

    @Test(expected = IllegalArgumentException.class)
    public void whenNLessNull() {
        Fact fact = new Fact();
        fact.calc(-2);
    }
}
