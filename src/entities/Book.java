package entities;
import application.Library_System;
import entities.Student;
import java.time.LocalDate;

public class Book {

    private int code;
    private String title;
    private String author;
    private boolean available;
    private int year;
    private Student student;
    private Loan loan;

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

    public void borrowBook(Student student) {
        this.student = student;
        available = false;
    }
    public void returnBook() {
        available = true;
        student = null;
    }

    public void setLoan(Loan loan) {
    }

    public String toString() {
        if (isAvailable()) {
            return "\nCode: "
                    + code
                    + "\nTitle: "
                    + title
                    + "\nAuthor: "
                    + author
                    + "\nYear: "
                    + year;
        } else {
            return "Book unavailable, will be returned on: "
                    + loan.getReturnDate();
        }
    }
}
