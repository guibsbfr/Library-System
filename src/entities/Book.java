package entities;

import enums.BookStatus;

import java.time.format.DateTimeFormatter;

public class Book {

    private BookStatus status;
    private int code;
    private String title;
    private String author;
    private int year;
    private Student student;
    private Loan loan;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Book() {
    }

    public Book(int code, String title, String author, int year) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.year = year;

        status = BookStatus.AVAILABLE;
    }

    public BookStatus getStatus() {
        return status;
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

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }

    public void borrow(Student student) {
        this.student = student;
        setStatus(BookStatus.UNAVAILABLE);
    }

    public void returnBook() {
        this.student = null;
        setStatus(BookStatus.AVAILABLE);
    }

    public String toString() {
        StringBuilder data = new StringBuilder();
            data.append("Title: ");
            data.append(title).append("\n");
            data.append("Author: ");
            data.append(author).append("\n");
            data.append("Year: ");
            data.append(year).append("\n");
            data.append("Status: ");
            data.append(status).append("\n");

            data.append("Lend for: ");
            data.append(student.getName()).append("\n");
            data.append("Will be return on: ");
            data.append(loan.getReturnDate().format(formatter)).append("\n");

        return data.toString();
    }
}
