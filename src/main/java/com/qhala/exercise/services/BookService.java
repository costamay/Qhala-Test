package com.qhala.exercise.services;

import com.qhala.exercise.entities.Book;
import com.qhala.exercise.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

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
