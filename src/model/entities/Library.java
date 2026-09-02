package model.entities;

import model.exceptions.DomainException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Library {

    public List<Student> students = new ArrayList<>();

    public void menu() {
        System.out.println();
        System.out.println("============ LIBRARY ============");
        System.out.println("1 - Register a book");
        System.out.println("2 - Search by code");
        System.out.println("3 - Search by title");
        System.out.println("4 - Search by author");
        System.out.println("5 - Lend book");
        System.out.println("6 - Return book");
        System.out.println("7 - List books");
        System.out.println("8 - List student loans");
        System.out.println("0 - Exit");
    }

    public void findDuplicatedCode(List<Book> list, int code) {
        for (Book book : list) {
            if (book.getCode() == code) {
                throw new DomainException("This code book already exist!");
            }
        }
    }

    public List<Book> findByAuthor(List<Book> list, String author) {
        List<Book> result = new ArrayList<>();
        for (Book b : list) {
            if (Objects.equals(b.getAuthor(), author)) {
                result.add(b);
            }
        }
        return result;
    }

    public Book findByTitle(List<Book> list, String title) {
        for (Book book : list) {
            if (Objects.equals(book.getTitle(), title)) {
                return book;
            }
        }
        return null;
    }

    public Book findByCodeUsingMap(Map<Integer, Book> map, int code) {
        return map.get(code);
    }

    public Student findStudentsByName(String name, int id) {
        for (Student std : students) {
            if (Objects.equals(std.getName(), name))
                if (Objects.equals(std.getId(), id)) {
                    return std;
                }
            }
        return null;
    }
}

