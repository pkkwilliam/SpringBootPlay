package com.william.SpringBootPlay.cache;

public interface BookRepository {

    Book getByIsbn(String isbn);

}
