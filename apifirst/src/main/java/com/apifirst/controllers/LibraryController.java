package com.apifirst.controllers;

import com.apifirst.libraryservice.api.LibraryApi;
import com.apifirst.libraryservice.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class LibraryController implements LibraryApi {

    @Override
    public ResponseEntity<List<Book>> getAllBooksInLibrary() {
        Book book = new Book();
        book.setBookAuthor("Test");
        book.setName("test");

        List<Book> books = new ArrayList<>(Arrays.asList(book));

        return ResponseEntity.ok(books);
    }
}
