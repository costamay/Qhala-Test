package com.qhala.exercise.controllers;

import com.qhala.exercise.entities.Book;
import com.qhala.exercise.entities.User;
import com.qhala.exercise.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/book/create")
    public ResponseEntity<?> addBook(@RequestBody Book book){
        Book bookSaved = bookService.addBook(book);
        return new ResponseEntity<Book>(bookSaved, HttpStatus.CREATED);
    }

    @GetMapping("/book/all")
    public ResponseEntity<List<Book>> getAll(){
        List<Book> listOfBooks = bookService.getAll();
        return new ResponseEntity<List<Book>>(listOfBooks, HttpStatus.OK);
    }

    @GetMapping("book/find/{id}")
    public ResponseEntity<?> findBookById(@PathVariable("id") Long id){
        Book bookRetrieved = bookService.findBookById(id);
        return new ResponseEntity<Book>(bookRetrieved, HttpStatus.OK);
    }

    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable("id") Long id){
        bookService.deleteBookById(id);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

}
