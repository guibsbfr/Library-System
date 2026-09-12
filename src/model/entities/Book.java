package model.entities;

import model.enums.BookStatus;

public class Book {

    private BookStatus status;
    private int code;
    private String title;
    private String author;
    private int year;

    public Book() {}

    public Book(int code, String title, String author, int year) {
        this.code = code;
        this.title = title;
        this.author = author;
        this.year = year;

        status = BookStatus.AVAILABLE;
    }

    public BookStatus getStatus() {
        return status;
    }

    public Integer getCode() {
        return code;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getYear() {
        return year;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
