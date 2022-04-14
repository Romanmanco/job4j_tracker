package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Output output = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new CreateAction(output),
                new ExitAction(output)));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findAll().get(0).getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ReplaceAction(output),
                new ExitAction(output)));
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new DeleteAction(output),
                new ExitAction(output)));
        new StartUI(output).init(in, tracker, actions);
        assertNull(tracker.findById(item.getId()));
    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(List.of(
                new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu:" + System.lineSeparator()
                        + "0. Exit" + System.lineSeparator()
                        + "=== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(one.getId()), replaceName, "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new ReplaceAction(output),
                new ExitAction(output)));
        new StartUI(output).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString(), is(
                "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Edit item ====" + ln
                        + "Заявка изменена успешно." + ln
                        + "Menu:" + ln
                        + "0. Edit item" + ln
                        + "1. Exit" + ln
                        + "=== Exit Program ====" + ln
        ));
    }

    @Test
    public void whenFindAllItem() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[]{"0", "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindAllAction(output),
                new ExitAction(output)));
        new StartUI(output).init(in, tracker, actions);

        assertThat((output.toString()), is("Menu:"
                + System.lineSeparator() + "0. Show all items"
                + System.lineSeparator() + "1. Exit"
                + System.lineSeparator()
                + "=== Show all items ===="
                + System.lineSeparator()
                + item
                + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Show all items"
                + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindById() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("Replaced item"));
        Input in = new StubInput(
                new String[]{"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByIdAction(output),
                new ExitAction(output)));
        new StartUI(output).init(in, tracker, actions);
        assertThat((output.toString()), is("Menu:"
                + System.lineSeparator()
                + "0. Find item by Id"
                + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Find item by Id ===="
                + System.lineSeparator()
                + item + System.lineSeparator()
                + "Menu:"
                + System.lineSeparator()
                + "0. Find item by Id"
                + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenFindByName() {
        Output output = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = tracker.add(new Item("New item name"));
        String name = "New item name";
        Input in = new StubInput(
                new String[]{"0", name, "1"}
        );
        List<UserAction> actions = new ArrayList<>(Arrays.asList(
                new FindByNameAction(output),
                new ExitAction(output)));
        new StartUI(output).init(in, tracker, actions);
        assertThat((output.toString()), is("Menu:"
                + System.lineSeparator()
                + "0. Find item by name"
                + System.lineSeparator()
                + "1. Exit"
                + System.lineSeparator()
                + "=== Find items by name ===="
                + System.lineSeparator()
                + item
                + System.lineSeparator()
                + "Menu:" + System.lineSeparator()
                + "0. Find item by name"
                + System.lineSeparator()
                + "1. Exit" + System.lineSeparator()
                + "=== Exit Program ====" + System.lineSeparator()
        ));
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"8", "0"}
        );
        MemTracker tracker = new MemTracker();
        List<UserAction> actions = new ArrayList<>(List.of(
                new ExitAction(out)));
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                        "Menu:" + ln
                                + "0. Exit" + ln
                                + "Wrong input, you can select: 0.. 0" + ln
                                + "Menu:" + ln
                                + "0. Exit" + ln
                                + "=== Exit Program ====" + ln
                )
        );
    }
}