package ru.pojo;

public class Library {
    public static void main(String[] args) {

        Book[] books = {new Book("Война и мир", 500),
                new Book("Идиот", 700),
                new Book("Мертвые души", 600),
                new Book("Clean code", 1000)};

        for (Book book : books) {
            System.out.println("Название книги: " + book.getName() + " - " + book.getNumberPages() + " страниц");
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (Book book : books) {
            System.out.println("Название книги: " + book.getName() + " - " + book.getNumberPages() + " страниц");
        }

        for (Book book : books) {
            if ("Clean code".equals(book.getName())) {
                System.out.println("Название книги: " + book.getName() + " - " + temp.getNumberPages() + " страниц");
            }
        }
    }
}
