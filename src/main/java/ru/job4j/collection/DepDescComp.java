package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        String obj1 = o1.split("/")[0];
        String obj2 = o2.split("/")[0];
        int compare = obj2.compareTo(obj1);
        return compare == 0 ? o1.compareTo(o2) : compare;
    }
}
