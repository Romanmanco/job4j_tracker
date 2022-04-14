package ru.job4j.tracker;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by name";
    }

    @Override
    public boolean execute(Input input, MemTracker tracker) {
        out.println("=== Find items by name ====");
        String name = input.askStr("Enter name: ");
        List<Item> array = tracker.findByName(name);
        if (array.size() > 0) {
            for (Item item : array) {
                out.println(item);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
