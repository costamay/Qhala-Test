package com.qhala.exercise.services;

import com.qhala.exercise.entities.Book;
import com.qhala.exercise.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public Optional<Book> findById(long id){
        return bookRepository.findById(id);
    }
}
