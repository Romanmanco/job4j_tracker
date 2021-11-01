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
                new String[] {"2", "2"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(2));
        Output out1 = new StubOutput();
        Input in1 = new StubInput(
                new String[] {"3", "3"}
        );
        ValidateInput input1 = new ValidateInput(out1, in1);
        int selected1 = input1.askInt("Enter menu:");
        assertThat(selected1, is(3));
    }

    @Test
    public void whenInvalidInputLess0() {
    Output out = new StubOutput();
    Input in = new StubInput(
            new String[]{"-1", "4"}
    );
    ValidateInput input = new ValidateInput(out, in);
    int selected = input.askInt("Enter menu:");
    assertThat(selected, is(4));
    }
}