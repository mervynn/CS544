package edu.mum.cs544.domain;

public class Book {
    private Integer id;
    private String title;
    private String ISBN;
    private String author;

    public Book(Integer id, String title, String ISBN, String author) {
        this.id = id;
        this.title = title;
        this.ISBN = ISBN;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
