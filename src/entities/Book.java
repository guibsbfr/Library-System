package entities;
import application.Library_System;
import entities.Student;

public class Book {

    private int code;
    private String title;
    private String author;
    private boolean available;
    private int year;
    private Student student;

    public Book() {
    }

    public Book(int code, String title, String author, int year) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.year = year;
        this.available = true;
    }

    public Integer getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public boolean isAvailable() {
        return available;
    }
    public String loanInfo() {
        if (student != null) {
            return "Code: " + code
                    + "\nTitle: " + title
                    + "\nAuthor: " + author
                    + "\nLend for: " + student.getName();
        }
        return "Book available";
    }

    public void borrowBook(Student student) {
        this.student = student;
        available = false;
    }
    public void returnBook() {
        available = true;
        student = null;
    }

    public String toString() {
        return "Code: " + code
                + "\nTitle: " + title
                + "\nAuthor: " + author
                + "\nYear: " + year
                + "\nAvailable: " + available;
    }
}
