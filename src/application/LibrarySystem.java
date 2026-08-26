package application;

import entities.Book;
import entities.Loan;
import entities.Student;
import enums.BookStatus;

import java.time.format.DateTimeFormatter;
import java.util.*;

import static entities.Library.*;

public class LibrarySystem {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        List<Book> list = new ArrayList<>();
        Map<Integer, Book> bookMap = new HashMap<>();

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
                        bookMap.put(code, book);
                    }
                    break;
                case 2:
                    System.out.print("Book code: ");
                    int code2 = sc.nextInt();

                    book = findByCode(list, code2);

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
                    sc.nextLine();
                    String author = sc.nextLine();

                    List<Book> booksByAuthor = findByAuthor(list, author);

                    if (booksByAuthor.isEmpty()) {
                        System.out.println("No books found for this author.");
                    } else {
                        for (Book b : booksByAuthor) {
                            System.out.println(b);
                        }
                    }
                    break;
                case 5:
                    System.out.print("Type book code that you want: ");
                    int code3 = sc.nextInt();

                    book = findByCodeUsingMap(bookMap, code3);

                    if (book == null) {
                        System.out.print("Book not found.");
                    } else {
                        if (book.getStatus() == BookStatus.AVAILABLE) {
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
                            book.borrow(student);
                            System.out.println("Successfully, you will return the book on " + loan.getReturnDate().format(formatter));


                        } else {
                            System.out.println(book);
                        }
                    }
                    break;
                case 6:

                    System.out.print("Which book do you wanna return? ");
                    int code4 = sc.nextInt();

                    book = findByCodeUsingMap(bookMap, code4);

                    if (book == null) {
                        System.out.println("This book is not part of our library.");
                    } else {
                        if (book.getStatus() == BookStatus.AVAILABLE) {
                            System.out.println("This book is already returned");
                        }
                        else {
                            System.out.println("Thanks for return book.");
                            book.returnBook();
                        }
                    }
                    break;
                case 7:
                    System.out.println("This is a list of books:\n");
                    for (Book b : list) {
                        System.out.println(b);
                    }
                    break;
                case 0:
                    System.out.print("End program");
                    break;

            }
        } while (option != 0);

        sc.close();
    }
}