package entities;

import enums.BookStatus;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Loan {
    private Student student;
    private Book book;
    private LocalDate returnDate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Loan(Student student, Book book) {

        if (book.getStatus() == BookStatus.UNAVAILABLE) {
            System.out.println("Unavailable book");
        }
        LocalDate date = LocalDate.now();
        this.returnDate = date.plusDays(15);

        this.student = student;
        this.book = book;

        book.borrow(student);
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
