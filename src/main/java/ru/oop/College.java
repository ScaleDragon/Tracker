package ru.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student student = (Student) freshman; //Down casting
        Object object = student;             //Up casting
    }
}
