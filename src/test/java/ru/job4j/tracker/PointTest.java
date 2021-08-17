package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.oop.Point;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class PointTest {
    @Test
    public void aToB() {
        Point a = new Point(1, 2);
        Point b = new Point(4, 2);
        double rsl = a.distance(b);
        assertThat(rsl, closeTo(3, 0.1));
    }

    @Test
    public void aToC() {
        Point a = new Point(1, 2);
        Point c = new Point(3, 5);
        double rsl = a.distance(c);
        assertThat(rsl, closeTo(3.6, 0.1));
    }

    @Test
    public void cToB() {
        Point c = new Point(3, 5);
        Point b = new Point(4, 2);
        double rsl = c.distance(b);
        assertThat(rsl, closeTo(3.1, 0.1));
    }

    @Test
    public void xYZ() {
        Point a = new Point(3, 5, 6);
        Point c = new Point(3, 5, 1);
        Point b = new Point(4, 2, 2);
        double rsl = a.distance3d(b);
        assertThat(rsl, closeTo(5, 0.1));
    }
}
