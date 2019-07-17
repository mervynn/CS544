package edu.mum.cs544.controller;

import edu.mum.cs544.domain.Book;
import edu.mum.cs544.service.ITestService;
import edu.mum.framework.annotations.*;
import edu.mum.framework.core.MyModel;

import java.util.ArrayList;
import java.util.List;

@MyController
@MyRequestMapping("/")
public class TestController {

    @MyAutowired
    ITestService iTestService;

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
    public List<Book> rest(){
        List<Book> books = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            books.add(new Book(i, "title" + i , "ISBN" + i, "Author" + i));
        return books;

    }
}
