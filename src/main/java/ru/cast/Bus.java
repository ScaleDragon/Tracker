package ru.cast;

public class Bus implements Vehicle {
    @Override
    public void move() {
        System.out.println("Автобус движется по дороге");
    }

    @Override
    public void getType() {
        System.out.println("Дорожный транспорт");
    }
}
