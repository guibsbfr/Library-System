package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Library {


    public static void menu() {
        System.out.println();
        System.out.println("============ LIBRARY ============");
        System.out.println("1 - Register a book");
        System.out.println("2 - Search by code");
        System.out.println("3 - Search by title");
        System.out.println("4 - Search by author");
        System.out.println("5 - Lend book");
        System.out.println("6 - Return book");
        System.out.println("7 - List books");
        System.out.println("0 - Exit");
    }
    public static Book findByCode(List<Book> list, int code) {
        for (Book b : list) {
            if (b.getCode() == code) {
                return b;
            }
        }
        return null;
    }
    public static Book findByAuthor(List<Book> list, String author) {
        for (Book a : list) {
            if (Objects.equals(a.getAuthor(), author)) {
                return a;
            }
        }
        return null;
    }
    public static Book findByTitle(List<Book> list, String title) {
        for (Book t : list) {
            if (Objects.equals(t.getTitle(), title)) {
                return t;
            }
        }
        return null;
    }
}

