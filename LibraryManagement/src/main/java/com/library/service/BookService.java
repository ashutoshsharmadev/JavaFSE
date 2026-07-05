package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository = new BookRepository();

    public void displayService() {
        System.out.println("BookService Created.");
        bookRepository.displayRepository();
    }
}
