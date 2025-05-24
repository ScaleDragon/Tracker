package ru.tracker;

public class ReplaceAction implements UserAction {
    private final Output output;

    public ReplaceAction(Output output) {
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
