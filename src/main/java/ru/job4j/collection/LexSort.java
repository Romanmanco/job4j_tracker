package ru.job4j.collection;

import java.util.Comparator;

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
        String taskNum = left.split("\\.")[0];
        int leftInt = Integer.parseInt(taskNum);
        taskNum = right.split("\\.")[0];
        int rightInt = Integer.parseInt(taskNum);

        return Integer.compare(leftInt, rightInt);
    }
}