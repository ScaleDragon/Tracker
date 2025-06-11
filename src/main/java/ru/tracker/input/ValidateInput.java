package ru.tracker.input;

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) throws NumberFormatException {
        while (true) {
            try {
                return Integer.parseInt(askStr(question));
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
        }
    }
}
