package ru.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int result = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                result = i;
            }
        }
        if (result == -1) {
            throw new ElementNotFoundException("Element with the key \"" + key + "\" not found");
        }
        return result;
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"1", "2", "5"}, "7");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
