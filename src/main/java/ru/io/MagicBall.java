package ru.io;

import java.util.Random;
import java.util.Scanner;

public class MagicBall {

    public static void main(String[] args) {
        System.out.println("Я великий Оракул. Что ты хочешь узнать? ");
        System.out.println("Задавай только те вопросы, на которые можно ответить да или нет.");
        Scanner in = new Scanner(System.in);
        in.nextLine();
        int answer = new Random().nextInt(3);
        System.out.println(getAnswer(answer));
    }

    private static String getAnswer(int num) {
        return switch (num) {
            case 1 -> "Да";
            case 2 -> "Нет";
            default -> "Может быть";
        };
    }
}
