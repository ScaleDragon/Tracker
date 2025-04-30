package ru.oop;

public class Student {
    public void musik() {
        System.out.println("Tra, tra,tra");
    }

    public void sing() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.musik();
        petya.musik();
        petya.musik();
        petya.sing();
        petya.sing();
        petya.sing();
    }
}
