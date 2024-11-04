package org.example;

import java.util.HashMap;
import java.util.Map;

public class Library {
    private static Library instance;
    private Map<String, Book> books;

    private Library() {
        books = new HashMap<>();
    }

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.put(book.getTitle(), book);
    }

    public Book searchBook(String title) {
        Book book = books.get(title);
        return (book != null && book.isAvailable()) ? book : null;
    }
}
