package model.entities;

import model.enums.BookStatus;
import model.exceptions.DomainException;

import java.util.*;

public class Library {

    public static Book book;

    private final List<Student> students = new ArrayList<>();
    private List<Book> list = new ArrayList<>();
    private final Map<Integer, Book> bookMap = new HashMap<>();

    public List<Student> getStudents() {
        return students;
    }

    public List<Book> getList() {
        return list;
    }

    public Map<Integer, Book> getBookMap() {
        return bookMap;
    }

    public void borrow() {
        if (book.getStatus() != BookStatus.AVAILABLE) {
            throw new DomainException("This book is unavailable");
        }else {
            book.setStatus(BookStatus.UNAVAILABLE);
        }
    }

    public void returnBook(Book book) {
        if (book == null) {
            throw new DomainException("Book is not part of our library.");
        }
        if (book.getStatus() == BookStatus.AVAILABLE) {
            throw new DomainException("Book is already available.");
        }
        book.setStatus(BookStatus.AVAILABLE);
    }
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
        throw new DomainException("This student is already registered");
    }

    public void addBook(Book book) {
        list = Collections.singletonList(book);
    }
}

