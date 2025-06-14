package ru.tracker;

import org.junit.jupiter.api.Test;
import ru.tracker.action.*;
import ru.tracker.input.Input;
import ru.tracker.input.MockInput;
import ru.tracker.output.MockOutput;
import ru.tracker.output.Output;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Output output = new MockOutput();
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}, output);
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new Create(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenDeleteItem() {
        Output output = new MockOutput();
        Input input = new MockInput(new String[]{"0", "1", "1"}, output);
        Tracker tracker = new Tracker();
        tracker.add(new Item("Item"));
        tracker.add(new Item("test"));
        tracker.add(new Item("test 2"));
        UserAction[] actions = {
                new Delete(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        assertThat(tracker.findById(1)).isEqualTo(null);
    }

    @Test
    void whenReplaceItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[]{"0", String.valueOf(one.getId()), replaceName, "1"}, output);
        UserAction[] actions = new UserAction[]{
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Изменение заявки ===" + ln
                        + "Введите ID заявки: " + ln
                        + "Введите имя заявки: " + ln
                        + "Заявка изменена" + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenReplaceItemTestOutputIsNotSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item("test1"));
        Item two = tracker.add(new Item("test2"));
        String replaceName = "New Test Name";
        Input input = new MockInput(
                new String[]{"0", "3", replaceName, "1"}, output);
        UserAction[] actions = new UserAction[]{
                new Replace(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Изменение заявки ===" + ln
                        + "Введите ID заявки: " + ln
                        + "Введите имя заявки: " + ln
                        + "=== Заявки с ID 3 не существут ===" + ln
                        + "Меню:" + ln
                        + "0. Изменить заявку" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item(("item 1")));
        Item two = tracker.add(new Item("test 2"));
        Input input = new MockInput(new String[]{"0", "1"}, output);
        UserAction[] actions = new UserAction[]{
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Вывод всех заявок ===" + ln
                        + one + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindAllItemTestOutputIsNotSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"0", "1"}, output);
        UserAction[] actions = new UserAction[]{
                new FindAll(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Вывод всех заявок ===" + ln
                        + "Хранилище еще не содержит заявок" + ln
                        + "Меню:" + ln
                        + "0. Показать все заявки" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item(("item 1")));
        Item two = tracker.add(new Item("item 2"));
        Input input = new MockInput(new String[]{"0", two.getName(), "1"}, output);
        UserAction[] actions = new UserAction[]{
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Показать заявки по имени ===" + ln
                        + "Введите имя заявки: " + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByNameItemTestOutputIsNotSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item(("item 1")));
        Item two = tracker.add(new Item("item 2"));
        Input input = new MockInput(new String[]{"0", "item 3", "1"}, output);
        UserAction[] actions = new UserAction[]{
                new FindByName(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Показать заявки по имени ===" + ln
                        + "Введите имя заявки: " + ln
                        + "Заявки с таким именем не найдены" + ln
                        + "Меню:" + ln
                        + "0. Показать заявки по имени" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdItemTestOutputIsSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item(("item 1")));
        Item two = tracker.add(new Item("item 2"));
        Input input = new MockInput(new String[]{"0", String.valueOf(two.getId()), "1"}, output);
        UserAction[] actions = new UserAction[]{
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Показать заявку ===" + ln
                        + "Введите ID заявки: " + ln
                        + two + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenFindByIdItemTestOutputIsNotSuccessfully() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Item one = tracker.add(new Item(("item 1")));
        Item two = tracker.add(new Item("item 2"));
        Input input = new MockInput(new String[]{"0", "3", "1"}, output);
        UserAction[] actions = new UserAction[]{
                new FindById(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo(
                "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Показать заявку ===" + ln
                        + "Введите ID заявки: " + ln
                        + "Такой заявки не существует" + ln
                        + "Меню:" + ln
                        + "0. Показать заявку по id" + ln
                        + "1. Завершить программу" + ln
                        + "Выбрать: " + ln
                        + "=== Завершение программы ===" + ln
        );
    }

    @Test
    void whenInvalidExit() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"2", "1"}, output);
        UserAction[] actions = new UserAction[]{
                new Create(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo("Меню:" + ln
                + "0. Добавить новую заявку" + ln
                + "1. Завершить программу" + ln
                + "Выбрать: " + ln
                + "Меню:" + ln
                + "0. Добавить новую заявку" + ln
                + "1. Завершить программу" + ln
                + "Выбрать: " + ln
                + "=== Завершение программы ===" + ln);
    }

    @Test
    void whenCorrectExit() {
        Output output = new MockOutput();
        Tracker tracker = new Tracker();
        Input input = new MockInput(new String[]{"1"}, output);
        UserAction[] actions = new UserAction[]{
                new Create(output),
                new Exit(output)
        };
        new StartUI(output).init(input, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(output.toString()).isEqualTo("Меню:" + ln
                + "0. Добавить новую заявку" + ln
                + "1. Завершить программу" + ln
                + "Выбрать: " + ln
                + "=== Завершение программы ===" + ln);
    }
}