package ru.job4j.tracker.item;

import java.util.Comparator;

public class ItemDescByName implements Comparator<Item> {

    @Override
    public int compare(Item second, Item first) {
        return first.getName().compareTo(second.getName());
    }
}
