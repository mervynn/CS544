package edu.mum.cs544;

import java.util.Date;

public class Test {
    public static void main(String[] args) {
        Book book = Book.builder().title("Game of throne")
                .ISBN("123123")
                .price(99)
                .publish_date(new Date())
                .author("Jon snow").build();
        System.out.println(book);

    }
}
