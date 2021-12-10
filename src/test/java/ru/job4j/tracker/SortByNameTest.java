package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.item.Item;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Item> expected = items.stream().sorted(Comparator.
                comparing(Item::getName)).collect(Collectors.toList());
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
        List<Item> expected = items.stream()
                .sorted(Comparator.comparingInt(Item::getPriority)
                        .reversed())
                .collect(Collectors.toList());
        items.sort(Collections.reverseOrder());
        assertThat(items, is(expected));
    }
}
