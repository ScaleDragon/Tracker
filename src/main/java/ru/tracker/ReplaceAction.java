package ru.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "Изменить заявку";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Изменение заявки ===");
        int id = input.askInt("Введите ID заявки: ");
        String name = input.askStr("Введите имя заявки: ");
        Item item = new Item(name);
        if (tracker.replace(id, item)) {
            System.out.println("=== Заявка изменена ===\n" + item);
        } else {
            System.out.println("=== Заявки с ID " + id + " не существут ===");
        }
        return true;
    }
}
