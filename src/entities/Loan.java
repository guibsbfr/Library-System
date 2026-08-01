package entities;

import enums.BookStatus;

import java.time.LocalDate;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Loan {
    public Student student;
    public Book book;
    private LocalDate returnDate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Loan(Student student, Book book) {

        if (book.getStatus() == BookStatus.UNAVAILABLE) {
            System.out.println("Unavailable book");
            return;
        }
        LocalDate date = LocalDate.now();
        this.returnDate = date.plusDays(15);

        this.student = student;
        this.book = book;

        book.borrowBook(student);
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public String toString() {
        if (book.getStatus() == BookStatus.UNAVAILABLE) {
            return  "\nLend for: "
                    + student.getName()
                    + "\nBook, unavailable!"
                    + "\nWill be returned on "
                    + returnDate.format(formatter);
        }
        else {
            return "Book available";
        }
    }
}
