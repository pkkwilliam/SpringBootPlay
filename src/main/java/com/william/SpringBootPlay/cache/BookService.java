package com.william.SpringBootPlay.cache;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class BookService implements BookRepository{

    @Cacheable("books")
    @Override
    public Book getByIsbn(String isbn) {
        databaseCall();
        System.out.println("???");
        return new Book(isbn, "Book Title");
    }

    private void databaseCall() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
