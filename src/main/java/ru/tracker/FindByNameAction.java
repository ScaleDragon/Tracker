package ru.tracker;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "Показать заявки по имени";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Показать заявки по имени ===");
        String name = input.askStr("Введите имя заявки: ");
        Item[] item = tracker.findByName(name);
        if (item.length > 0) {
            for (Item rls : item) {
                System.out.println(rls);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
