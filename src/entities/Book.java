package entities;
import application.LibrarySystem;
import entities.Student;
import enums.BookStatus;

import java.time.LocalDate;

public class Book {

    private BookStatus status;
    private int code;
    private String title;
    private String author;
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

    }

    public BookStatus getStatus() {
       return status = BookStatus.AVAILABLE;
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

    public void setStatus(BookStatus bookStatus) {
    }

    public void borrowBook(Student student) {
        this.student = student;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public String toString() {
        if (student == null) {
            return "\nCode: "
                    + code
                    + "\nTitle: "
                    + title
                    + "\nAuthor: "
                    + author
                    + "\nYear: "
                    + year;
        } else {
            return loan.toString();
        }
    }
}
