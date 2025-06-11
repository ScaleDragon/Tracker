package ru.tracker.input;

public class ValidateInput extends ConsoleInput {
    @Override
    public int askInt(String question) {
        while (true) {
            try {
                return super.askInt(question);
            } catch (NumberFormatException e) {
                System.out.println("Пожалуйста, введите корректные данные");
            }
        }
    }
}
