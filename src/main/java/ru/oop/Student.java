package ru.oop;

public class Student extends Freshman {
    public void music() {
        System.out.println("Tra, tra,tra");
    }

    public void sing() {
        System.out.println("I believe I can fly");
    }

    public static void main(String[] args) {
        Student petya = new Student();
        petya.music();
        petya.music();
        petya.music();
        petya.sing();
        petya.sing();
        petya.sing();
    }
}
