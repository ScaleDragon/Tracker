package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class Replace implements UserAction {
    private final Output output;

    public Replace(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Изменение заявки ===");
        int id = input.askInt("Введите ID заявки: ");
        String name = input.askStr("Введите имя заявки: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            output.println("Заявка изменена");
        } else {
            output.println("=== Заявки с ID " + id + " не существут ===");
        }
        return true;
    }
}
