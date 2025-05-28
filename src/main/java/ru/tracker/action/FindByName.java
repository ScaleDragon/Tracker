package ru.tracker.action;

import ru.tracker.input.Input;
import ru.tracker.Item;
import ru.tracker.output.Output;
import ru.tracker.Tracker;

public class FindByName implements UserAction {
    private final Output output;

    public FindByName(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        output.println("=== Показать заявки по имени ===");
        String name = input.askStr("Введите имя заявки: ");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (Item rls : item) {
                output.println(rls);
            }
        } else {
            output.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
