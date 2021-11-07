package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "0"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(0));
    }

    @Test
    public void whenManyValidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"2", "3", "4"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        int selected1 = input.askInt("Enter menu:");
        int selected2 = input.askInt("Enter menu:");
            assertThat(selected, is(2));
            assertThat(selected1, is(3));
            assertThat(selected2, is(4));
    }

    @Test
    public void whenInvalidInputLess0() {
    Output out = new StubOutput();
    Input in = new StubInput(
            new String[]{"-1", "4"}
    );
    ValidateInput input = new ValidateInput(out, in);
    int selected = input.askInt("Enter menu:");
    assertThat(selected, is(-1));
    }
}