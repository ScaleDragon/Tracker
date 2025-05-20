package ru.tracker;

public class StartUI {

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            showMenu();
            int select = input.askInt("Выбрать: ");
            if (select == 0) {
                System.out.println("=== Создание новой заявки ===");
                String name = input.askStr("Введите имя:");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Добавленная заявка: " + item);
            } else if (select == 1) {
                System.out.println("=== Вывод всех заявок ===");
                Item[] array = tracker.findAll();
                if (array.length != 0) {
                    for (Item item : array) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("Хранилище еще не содержит заявок");
                }
            } else if (select == 2) {
                System.out.println("=== Изменение заявки ===");
                int id = input.askInt("Введите ID заявки: ");
                String name = input.askStr("Введите имя заявки: ");
                Item item = new Item(name);
                if (tracker.replace(id, item)) {
                    System.out.println("=== Заявка изменена ===\n" + item);
                } else {
                    System.out.println("=== Заявки с ID " + id + " не существут ===");
                }
            } else if (select == 3) {
                System.out.println("=== Удаление заявки ===");
                int id = input.askInt("Введите ID заявки: ");
                Item item = tracker.findById(id);
                tracker.delete(id);
                System.out.println(item != null ? "Заявка удалена успешно." : "Ошибка удаления заявки.");

            } else if (select == 4) {
                System.out.println("=== Показать заявку ===");
                int id = input.askInt("Введите ID заявки: ");
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(item);
                } else {
                    System.out.println("Такой заявки не существует");
                }
            } else if (select == 5) {
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
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        String[] menu = {
                "Добавить новую заявку", "Показать все заявки", "Изменить заявку",
                "Удалить заявку", "Показать заявку по id", "Показать заявки по имени", "Завершить программу"
        };
        System.out.println("Меню:");
        for (int i = 0; i < menu.length; i++) {
            System.out.println(i + ". " + menu[i]);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
