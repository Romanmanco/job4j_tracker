package ru.job4j.lambda;

import java.util.Comparator;

public class Attachment implements Comparator<Attachment> {
    private String name;
    private int size;

    public Attachment(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "{"
                + "name='" + name + '\''
                + ", size=" + size
                + '}';
    }

    @Override
    public int compare(Attachment left, Attachment right) {
        return left.getSize() - right.getSize();
    }
}
