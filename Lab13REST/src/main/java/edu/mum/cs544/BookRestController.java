package edu.mum.cs544;

import edu.mum.cs544.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookRestController {

    @Autowired
    BookService bookService;

    @GetMapping("/books")
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @GetMapping("/books/{id}")
    public Book get(@PathVariable int id) {
        return bookService.get(id);
    }

    @PostMapping("/books")
    public RedirectView add(@RequestBody Book book) {
        Book b = bookService.add(book);
        return new RedirectView("/api/books/"+b.getId());
    }

    @PutMapping("/books/{id}")
    public void update(@RequestBody Book book, @PathVariable Integer id) {
        bookService.update(book);
    }

    @DeleteMapping("books/{id}")
    public void delete(@PathVariable int id) {
        bookService.delete(id);
    }
}
