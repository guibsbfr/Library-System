package model.entities;

import model.enums.BookStatus;
import model.exceptions.DomainException;

import java.time.LocalDate;

public class Loan {

    private final Book book;
    private final LocalDate returnDate;
    private final Student student;

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

    public void borrow() {
        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new DomainException("This book is unavailable");
        }else {
            book.setStatus(BookStatus.UNAVAILABLE);
        }
    }

    public void returnBook() {
        if (book == null) {
            throw new DomainException("Book is not part of our library.");
        }
        if (book.getStatus() == BookStatus.AVAILABLE) {
            throw new DomainException("Book is already available.");
        }
        book.setStatus(BookStatus.AVAILABLE);
    }
}
