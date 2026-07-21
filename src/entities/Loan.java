package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

public class Loan {
    private Student student;
    private Book book;
    public LocalDate date;
    public LocalDate returnDate;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Loan(Student student, Book book) {

        if (!book.isAvailable()) {
            System.out.println("Unavailable book");
            return;
        }
        this.date = LocalDate.now();
        this.returnDate = date.plusDays(15);

        this.student = student;
        this.book = book;

        book.borrowBook(student);
    }

    public Book getBook() {
        return book;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public LocalDate getDate() {
        return date;
    }

    public Student getStudent() {
        return student;
    }


    public String toString() {
        if (student != null) {
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
