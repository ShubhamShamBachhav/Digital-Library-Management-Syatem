package com.Library.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Library.Model.Book;
import com.Library.repository.BookRepository;

@Service
public class Bookservice {

    @Autowired
    private BookRepository bookRepository;

    
    //Get Book--------------------
    
    public List<Book> getAllBooks() 
    { 
    	return bookRepository.findAll(); 
    }

    public Optional<Book> getBookById(Long id) 
    { 
    	return bookRepository.findById(id); 
    }
    
    //OR
    
    public Optional<Book> getBookByTitle(String title) 
    {
    	return bookRepository.findByTitle(title); 
    }

    
    //Add Book-------------------------------------
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    //Update Book-------------------------------------------
    
    public Book updateBook(Book book) 
    { 
    	return bookRepository.save(book); 
    }

    //Delete Book--------------------------------------------
    
    public void deleteBook(Long id) 
    { 
    	bookRepository.deleteById(id); 
    }
}
