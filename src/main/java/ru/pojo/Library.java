package ru.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", 500);
        Book book2 = new Book("Идиот", 700);
        Book book3 = new Book("Мертвые души", 600);
        Book book4 = new Book("Clean code", 1000);

        Book[] books = {book1, book2, book3, book4};

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Название книги: " + book.getName() + " - " + book.getNumberPages() + " страниц");
        }

        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            System.out.println("Название книги: " + book.getName() + " - " + temp.getNumberPages() + " страниц");
        }

        for (int i = 0; i < books.length; i++) {
            Book book = books[i];
            if (book.getName().equals("Clean code")) {
                System.out.println("Название книги: " + book.getName() + " - " + temp.getNumberPages() + " страниц");
            }
        }
    }
}
