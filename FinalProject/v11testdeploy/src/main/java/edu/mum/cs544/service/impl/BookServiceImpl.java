package edu.mum.cs544.service.impl;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.repository.BookRepository;
import edu.mum.cs544.service.IBookService;
import edu.mum.framework.annotations.MyAutowired;
import edu.mum.framework.annotations.MyService;
import edu.mum.framework.annotations.MyTransactional;

import java.util.List;

@MyService
@MyTransactional
public class BookServiceImpl implements IBookService {

    @MyAutowired
    BookRepository bookRepository;

    @Override
    public void saveBook(Book book) {
        // For test transaction
        // Every saveBook is succeed if having no @MyTransactional,
        // otherwise database hit happens when service method return/ends
        for (int i = 0; i < 5; i++)
            bookRepository.saveBook(new Book(i, "title" + i, "ISBN" + i, "Author" + i));
    }

    @Override
    public List<Book> getBooks() {
        return bookRepository.getBooks();
    }
}
