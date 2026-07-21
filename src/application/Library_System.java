package application;

import entities.Book;
import entities.Loan;
import entities.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static entities.Library.*;

public class Library_System {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Book> list = new ArrayList<>();
        List<Student> studentsList = new ArrayList<>();

        int option;

        do {
            menu();

            System.out.print("Choose an option: ");
            option = sc.nextInt();

            Book book;
            switch (option) {
                case 1:
                    System.out.print("Book code: ");
                    int code = sc.nextInt();
                    book = findByCode(list, code);

                    if (book != null) {
                        System.out.print("This book code already exist");
                    } else {
                        System.out.print("Book title: ");
                        sc.nextLine();
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Year: ");
                        int year = sc.nextInt();

                        book = new Book(code, title, author, year);
                        list.add(book);
                    }
                    break;
                case 2:
                    System.out.print("Book code: ");
                    code = sc.nextInt();

                    book = findByCode(list, code);

                    if (book != null) {
                        System.out.print(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    System.out.print("Book title: ");
                    sc.nextLine();
                    String title = sc.nextLine();

                    book = findByTitle(list, title);

                    if (book != null) {
                        System.out.print(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Book author: ");
                    String author = sc.nextLine();

                    book = findByAuthor(list, author);

                    if (book != null) {
                        System.out.print(book);
                    } else {
                        System.out.print("Book not found.");
                    }
                    break;
                case 5:
                    System.out.print("Type book code that you want: ");
                    code = sc.nextInt();

                    book = findByCode(list, code);

                    if (book == null) {
                        System.out.print("Book not found.");
                    } else {
                        if (book.isAvailable()) {
                            System.out.print("Student name: ");
                            sc.nextLine();
                            String name = sc.nextLine();
                            System.out.print("Student ID: ");
                            int id = sc.nextInt();
                            System.out.print("Email: ");
                            sc.nextLine();
                            String email = sc.nextLine();

                            Student student = new Student(name, email, id);
                            Loan loan = new Loan(student, book);
                            book.setLoan(loan);

                            System.out.println("Successfully, you will return the book on " + loan.returnDate.format(formatter));

                        } else {
                            System.out.println(book);
                        }
                    }
                    break;
                case 6:

                    System.out.print("What book do you wanna return? ");
                    code = sc.nextInt();

                    book = findByCode(list, code);

                    if (book == null) {
                        System.out.println("Book not found.");
                    } else {
                        System.out.println("Thanks for return book.");
                        book.returnBook();
                    }
                    break;
                case 7:
                    System.out.println("This is a list of books:");
                    for (Book b : list) {
                        System.out.println(b);
                    }
                    break;
                case 0:
                    System.out.print("Finish program");
                    break;
            }
        } while (option != 0);

        sc.close();
    }
}