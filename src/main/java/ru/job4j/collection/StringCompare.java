package ru.job4j.collection;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int i = Integer.parseInt(left);
        int b = Integer.parseInt(right);
        int c = (i < b) ? -1 : (i == b) ? 0 : 1;
        String rsl = Integer.toString(c);
        return rsl;
    }
}
