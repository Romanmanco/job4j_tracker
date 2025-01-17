package ru.job4j.tracker.collection;

import org.junit.Test;
import ru.job4j.collection.User;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void whenAsc() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Petr", 32));
        users.add(new User("Ivan", 31));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Ivan", 31)));
        assertThat(it.next(), is(new User("Petr", 32)));
    }

    @Test
    public void whenNameEquails() {
        Set<User> users = new TreeSet<>();
        users.add(new User("Roman", 28));
        users.add(new User("Roman", 25));
        Iterator<User> it = users.iterator();
        assertThat(it.next(), is(new User("Roman", 25)));
        assertThat(it.next(), is(new User("Roman", 28)));
    }

    @Test
    public void whenComparePertVSIvan() {
        int rsl = new User("Petr", 32)
                .compareTo(
                        new User("Ivan", 31)
                );
        assertThat(rsl, greaterThan(0));
    }
}