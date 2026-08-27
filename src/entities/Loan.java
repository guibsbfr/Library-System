package entities;

import enums.BookStatus;

import java.time.LocalDate;

public class Loan {

    private final LocalDate returnDate;

    public Loan(Student student, Book book) {
        LocalDate date = LocalDate.now();
        this.returnDate = date.plusDays(15);
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }
}
