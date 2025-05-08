package ru.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        Item rsl = index != -1 ? items[index] : null;
        return rsl;
    }

    private int indexOf(int id) {
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                return index;
            }
        }
        return -1;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        int count = 0;
        Item[] rsl = new Item[size];
        for (int i = 0; i < size; i++) {
            if (items[i].getName() != null && key.equals(items[i].getName())) {
                rsl[count++] = items[i];
            }
        }
        return Arrays.copyOf(rsl, count);
    }
}