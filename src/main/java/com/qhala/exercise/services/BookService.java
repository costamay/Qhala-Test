package com.qhala.exercise.services;

import com.qhala.exercise.entities.Book;
import com.qhala.exercise.entities.User;
import com.qhala.exercise.exceptions.ResourceNotFoundException;
import com.qhala.exercise.repositories.BookRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id : " + id));
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
