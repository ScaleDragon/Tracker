package ru.cast;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println("Поезд движется по железной дороге");
    }

    @Override
    public void getType() {
        System.out.println("Железнодорожный транспорт");
    }
}
