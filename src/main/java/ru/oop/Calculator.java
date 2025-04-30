package ru.oop;

public class Calculator {
    private static final int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int minuend) {
        return minuend - x;
    }

    public int divide(int dividend) {
        return dividend / x;
    }

    public int sumAllOperation(int number) {
        return sum(number) + multiply(number) + minus(number) + divide(number);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println("Результат сложения: " + result);
        result = minus(10);
        System.out.println("Результат вычитания: " + result);

        Calculator calculator = new Calculator();
        result = calculator.multiply(5);
        System.out.println("Результат умножения: " + result);
        result = calculator.divide(5);
        System.out.println("Результат деления: " + result);
        result = calculator.sumAllOperation(5);
        System.out.println("Результат сложения всех операций: " + result);
    }
}
