package model.entities;

import model.enums.BookStatus;
import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {

    private final Book book;
    private final LocalDate returnDate;
    private final Student student;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Loan(Book book, Student student) {
        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new DomainException("This book is not available.");
        }
        this.student = student;
        this.book = book;

        LocalDate date = LocalDate.now();
        this.returnDate = date.plusDays(15);
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public Book getBook() {
        return book;
    }

    public Student getStudent() {
        return student;
    }

    public String toString(){
        StringBuilder data = new StringBuilder();
        data.append("Title: ");
        data.append(book.getTitle()).append("\n");
        data.append("Author: ");
        data.append(book.getAuthor()).append("\n");
        data.append("Year: ");
        data.append(book.getYear()).append("\n");
        data.append("Status: ");
        data.append(book.getStatus()).append("\n");

        if (getBook().getStatus() == BookStatus.UNAVAILABLE) {
            data.append("\n");
            data.append("Will be return on: ");
            data.append(getReturnDate().format(formatter));
        }
        return data.toString();
    }
}
