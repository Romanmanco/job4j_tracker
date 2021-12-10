package ru.job4j.tracker.item;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {

    @Override
    public int compare(Item first, Item second) {
        return first.getName().compareTo(second.getName());
    }
}
