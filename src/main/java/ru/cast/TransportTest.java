package ru.cast;

public class TransportTest {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus = new Bus();

        Vehicle[] vehicles = {plane, train, bus};
        for (Vehicle vehicle : vehicles) {
            vehicle.move();
            vehicle.getType();
            System.out.println("====================");
        }
    }
}
