package edu.mum.cs544.controller;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.service.IBookService;
import edu.mum.cs544.service.ITestService;
import edu.mum.framework.annotations.*;
import edu.mum.framework.core.MyModel;

import java.util.List;

@MyController
@MyRequestMapping("/")
public class TestController {

    @MyAutowired
    ITestService iTestService;

    @MyAutowired
    IBookService iBookService;

    @MyRequestMapping("/")
    public String init() {
        return "welcome";
    }

    @MyRequestMapping("/calculate")
    public String doSomething(@MyRequestParam("a") String theFirstNumber
            , String b, String operator, MyModel model) {
        String res = iTestService.calculate(theFirstNumber, b, operator);
        model.addAttribute("a", theFirstNumber);
        model.addAttribute("b", b);
        model.addAttribute("res", res);
        model.addAttribute("operator", operator);
        return "welcome";
    }

    @MyResponseBody
    @MyRequestMapping("/books")
    public List<Book> rest() {
        iBookService.saveBook(null);
        return iBookService.getBooks();

    }
}
