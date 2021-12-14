package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SortByNameTest {

    @Test
    public void sortAscName() {
        List<Item> items = Arrays.asList(
                new Item("a", 1),
                new Item("c", 3),
                new Item("b", 2)
        );
        List<Item> expected = Arrays.asList(
                new Item("a", 1),
                new Item("b", 2),
                new Item("c", 3)
        );
        Collections.sort(items);
        assertThat(items, is(expected));
    }

    @Test
    public void sortDescName() {
        List<Item> items = Arrays.asList(
                new Item("a", 1),
                new Item("c", 3),
                new Item("b", 2)
        );
        List<Item> expected = Arrays.asList(
                new Item("c", 3),
                new Item("b", 2),
                new Item("a", 1)
        );
        items.sort(Collections.reverseOrder());
        assertThat(items, is(expected));
    }
}
