package ru.tracker;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StartUITest {

    @Test
    void whenCreateItem() {
        Input input = new MockInput(
                new String[]{"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("Item name");
    }

    @Test
    void whenReplaceItem() {
        Input input = new MockInput(new String[]{"0", "1", "new name", "1"});
        Tracker tracker = new Tracker();
        Item item = new Item("Item");
        tracker.add(item);
        UserAction[] actions = {
                new ReplaceAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findAll()[0].getName()).isEqualTo("new name");
    }

    @Test
    void whenDeleteItem() {
        Input input = new MockInput(new String[]{"0", "1", "1"});
        Tracker tracker = new Tracker();
        Item item = new Item("Item");
        tracker.add(item);
        UserAction[] actions = {
                new DeleteAction(),
                new ExitAction()
        };
        new StartUI().init(input, tracker, actions);
        assertThat(tracker.findById(1)).isEqualTo(null);
    }
}