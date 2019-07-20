package edu.mum.cs544.service;

import edu.mum.cs544.domain.Book;

import java.util.List;

public interface IBookService {
    void saveBook(Book book);

    List<Book> getBooks();
}
