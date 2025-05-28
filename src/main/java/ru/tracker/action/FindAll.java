package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class FindAll implements UserAction {
    private final Output output;

    public FindAll(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать все заявки";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Вывод всех заявок ===");
        Item[] array = tracker.findAll();
        if (array.length != 0) {
            for (Item item : array) {
                output.println(item);
            }
        } else {
            output.println("Хранилище еще не содержит заявок");
        }
        return true;
    }
}
