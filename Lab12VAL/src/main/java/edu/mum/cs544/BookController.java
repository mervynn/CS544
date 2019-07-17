package edu.mum.cs544;

import edu.mum.cs544.domain.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
public class BookController {

    public BookController(){
        System.out.println("construct BookController");
    }

    @Resource
    private BookService bookService;

    @GetMapping("/")
    public String redirectRoot() {
        return "redirect:/books";
    }

    @GetMapping("/books")
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "bookList";
    }

    @PostMapping("/books")
    public String add(@Valid Book book, BindingResult result, RedirectAttributes attr) {
        if (result.hasErrors()) {
            attr.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
            attr.addFlashAttribute("book", book);
            return "redirect:/books/add";
        }
        bookService.add(book);
        return "redirect:/books";
    }

    @GetMapping("/books/add")
    public String viewAdd(Model model) {
        if(!model.containsAttribute("book"))
            model.addAttribute("book", new Book());
        model.addAttribute("msg", "Add");
        return "bookDetail";
    }

    @GetMapping("/books/{id}")
    public String get(@PathVariable int id, Model model) {
        if(!model.containsAttribute("book"))
            model.addAttribute("book", bookService.get(id));
        model.addAttribute("msg", "Update");
        return "bookDetail";
    }

    @PostMapping("/books/{id}")
    public String update(@Valid Book book, BindingResult result, @PathVariable int id,
                         RedirectAttributes attr) {
        if(result.hasErrors()){
            attr.addFlashAttribute("org.springframework.validation.BindingResult.book", result);
            attr.addFlashAttribute("book", book);
            return "redirect:/books/" + id;
        }
        bookService.update(book); // book.id already set by binding
        return "redirect:/books";
    }

    @PostMapping(value = "/books/delete")
    public String delete(int bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }
}
