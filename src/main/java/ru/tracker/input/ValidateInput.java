package ru.tracker.input;

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) throws NumberFormatException {
        return Integer.parseInt(askStr(question));
    }
}
