package ru.job4j.tracker;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] array = tracker.findAll();
        if (array.length > 0) {
            for (Item item : array) {
                System.out.println(item);
            }
        } else {
            System.out.println("Хранилище не содержет заявок.");
        }
        return true;
    }
}
