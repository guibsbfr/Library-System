package model.entities;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private String email;
    private int id;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private final List<Loan> loans = new ArrayList<>();

    public Student() {
    }

    public Student(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();

        data.append("Student: ").append(name).append("\n");
        data.append("ID: ").append(id).append("\n");
        data.append("Email: ").append(email).append("\n");

        data.append("\nLoans:\n");

        for (Loan loan : loans) {
            data.append("Book: ")
                    .append(loan.getBook().getTitle())
                    .append("\n");

            data.append("Return date: ")
                    .append(loan.getReturnDate().format(formatter))
                    .append("\n");

            data.append("--------------------\n");
        }

        return data.toString();
    }
}
