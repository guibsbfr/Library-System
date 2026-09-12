package application;

import model.entities.Book;
import model.entities.Library;
import model.entities.Loan;
import model.entities.Student;
import model.exceptions.DomainException;

import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Library library = new Library();

        int option;

        do {
            library.menu();

            System.out.print("Choose an option: ");
            option = sc.nextInt();

            Book book;
            switch (option) {
                case 1:
                    try {
                        System.out.print("Book code: ");
                        int code = sc.nextInt();

                        library.findDuplicatedCode(library.getList(), code);

                        System.out.print("Book title: ");
                        sc.nextLine();
                        String title = sc.nextLine();
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Year: ");
                        int year = sc.nextInt();

                        book = new Book(code, title, author, year);
                        library.addBook(book);
                        library.getBookMap().put(code, book);
                    } catch (DomainException e) {
                        System.out.println("Registration error: " + e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Book code: ");
                    int code2 = sc.nextInt();

                    book = library.findByCodeUsingMap(library.getBookMap(), code2);

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

                    book = library.findByTitle(library.getList(), title);

                    if (book != null) {
                        System.out.print(book);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.print("Book author: ");
                    sc.nextLine();
                    String author = sc.nextLine();

                    List<Book> booksByAuthor = library.findByAuthor(library.getList(), author);

                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books found for this author.");
                    } else {
                        for (Book b : booksByAuthor) {
                            System.out.println();
                            System.out.println(b);
                        }
                    }
                    break;
                case 5:
                    try {
                        System.out.print("Type book code that you want: ");
                        int code3 = sc.nextInt();

                        book = library.findByCodeUsingMap(library.getBookMap(), code3);

                        System.out.print("Student name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Student ID: ");
                        int id = sc.nextInt();
                        System.out.print("Email: ");
                        sc.nextLine();
                        String email = sc.nextLine();
                        try {
                            library.findStudentsByName(name, id);
                        }
                        catch (DomainException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        Student student = new Student(name, email, id);
                        Loan loan = new Loan(book, student);
                        student.getLoans().add(loan);
                        library.getStudents().add(student);
                        library.borrow();
                        System.out.println("Successfully, you will return the book on " + loan.getReturnDate().format(formatter));

                    } catch (DomainException e) {
                        System.out.println("Error in lend this book: " + e.getMessage());
                    } catch (RuntimeException e) {
                        System.out.println("Operation error.");
                    }
                    break;
                case 6:
                    try {
                        System.out.print("Which book do you wanna return? ");
                        int code4 = sc.nextInt();

                        book = library.findByCodeUsingMap(library.getBookMap(), code4);
                        Library.book = book;
                        library.returnBook(book);
                        System.out.println("Thanks for return book.");

                    } catch (DomainException e) {
                        System.out.println("Borrow denied: " + e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("This is a list of books:\n");
                    for (Book b : library.getList()) {
                        System.out.println(b);
                    }
                    break;
                case 8:
                    System.out.print("Student name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.print("Student ID: ");
                    int id = sc.nextInt();

                    Student student = library.findStudentsByName(name, id);
                    System.out.println(student);
                    break;
                case 0:
                    System.out.print("End program");
                    break;
            }
        } while (option != 0);
        sc.close();
    }
}