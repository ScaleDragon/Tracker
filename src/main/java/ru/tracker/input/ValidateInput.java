package ru.tracker.input;

import ru.tracker.output.Output;

public class ValidateInput implements Input {
    private final Output output;
    private final Input input;

    public ValidateInput(Output output, Input input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public String askStr(String question) {
        return input.askStr(question);
    }

    @Override
    public int askInt(String question) {
        while (true) {
            try {
                return input.askInt(question);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
        }
    }
}
