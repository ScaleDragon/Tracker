package ru.oop;

public class Ball {
    public void tryRun(boolean condition) {
        if (condition) {
            System.out.println("Kolobok is eaten");
        } else {
            System.out.println("Kolobok escaped");
        }
    }
}
