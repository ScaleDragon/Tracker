package ru.cast;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println("Самолет летит");
    }

    @Override
    public void getType() {
        System.out.println("Воздушный транспорт");
    }
}
