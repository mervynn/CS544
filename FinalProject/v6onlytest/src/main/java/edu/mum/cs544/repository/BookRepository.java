package edu.mum.cs544.repository;

import edu.mum.cs544.domain.Book;
import edu.mum.framework.annotations.MyRepository;

import java.util.List;

@MyRepository
public interface BookRepository {
    void saveBook(Book book);

    List<Book> getBooks();
}
