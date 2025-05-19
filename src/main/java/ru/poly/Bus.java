package ru.poly;

public class Bus implements Transport {

    @Override
    public void drive() {
        System.out.println("Автобус начал движение");
    }

    @Override
    public void quantityPassenger(int quantity) {
        System.out.println("Количество пассажиров: " + quantity);
    }

    @Override
    public int refun(int quantity) {
        return quantity * 61;
    }
}
