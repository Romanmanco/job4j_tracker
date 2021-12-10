package ru.job4j.tracker.item;

public class Item implements Comparable<Item> {
    private String name;
    private int priority;

    public Item(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Job{"
                + "name='" + name + '\''
                + ", priority=" + priority
                + '}';
    }

    @Override
    public int compareTo(Item another) {
        return Integer.compare(priority, another.priority);
    }
}