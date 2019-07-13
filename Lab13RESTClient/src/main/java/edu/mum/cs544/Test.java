package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Test implements CommandLineRunner {

    @Autowired
    BookService bookServiceApi;
    @Override
    public void run(String... args) throws Exception {
        Book book = bookServiceApi.get(1);
        Book newBook = new Book(null, "NewFromClient", "978-0-306-40615-7", "clientAuthor", 12d);
        bookServiceApi.add(newBook);
        System.out.println(bookServiceApi.getAll());
        book.setPrice(999d);
        bookServiceApi.update(book);
        System.out.println(bookServiceApi.getAll());
        bookServiceApi.delete(2);
        System.out.println(bookServiceApi.getAll());
        book = bookServiceApi.getAll().get(0);
        System.out.println(book.getTitle());
    }
}
