package ru.tracker.input;

import org.junit.jupiter.api.Test;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class ValidateInputTest {

    @Test
    void whenInvalidInput() {
        Output output = new MockOutput();
        Input in = new MockInput(new String[]{"one", "1"}, output);
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(1);
    }

    @Test
    void whenCorrectInput() {
        Output output = new MockOutput();
        Input in = new MockInput(new String[]{"2"}, output);
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(2);
    }

    @Test
    void whenAllCorrectInput() {
        Output output = new MockOutput();
        Input in = new MockInput(new String[]{"0", "1", "2"}, output);
        ValidateInput input = new ValidateInput(output, in);
        int selectedZero = input.askInt("Выбрать: ");
        assertThat(selectedZero).isEqualTo(0);
        int selectedOne = input.askInt("Выбрать: ");
        assertThat(selectedOne).isEqualTo(1);
        int selectedTwo = input.askInt("Выбрать: ");
        assertThat(selectedTwo).isEqualTo(2);
    }

    @Test
    void whenNegativeInput() {
        Output output = new MockOutput();
        Input in = new MockInput(new String[]{"-2"}, output);
        ValidateInput input = new ValidateInput(output, in);
        int selected = input.askInt("Выбрать: ");
        assertThat(selected).isEqualTo(-2);
    }
}