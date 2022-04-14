package ru.job4j.tracker;

import java.util.List;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("=== Show all items ====");
        List<Item> array = tracker.findAll();
        if (array.size() > 0) {
            for (Item item : array) {
                out.println(item);
            }
        } else {
            out.println("Хранилище не содержет заявок.");
        }
        return true;
    }
}
