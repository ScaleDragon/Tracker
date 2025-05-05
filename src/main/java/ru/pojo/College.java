package ru.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Мисаки");
        student.setSurname("Судзуки");
        student.setPatronymic("Тян");
        student.setGroup("A-1");
        student.setDateOfReceipt(new Date());
        System.out.println("name: " + student.getName() +
                "\nsurname: " + student.getSurname() +
                "\npatronymic: " + student.getPatronymic() +
                "\ngroup: " + student.getGroup() +
                "" +
                "\ndate of receipt: " + student.getDateOfReceipt());
    }
}
