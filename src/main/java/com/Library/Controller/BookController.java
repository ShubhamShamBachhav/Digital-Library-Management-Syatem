package com.Library.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Library.Model.Book;
import com.Library.service.Bookservice;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private Bookservice bookService;

 //SELECT/GET All data at a time--------------------------------------------------------------------------------------------------------------------------------
    @GetMapping
    public List<Book> getAllBooks() 
    {
    	return bookService.getAllBooks(); 
    }

 //SELECT/GET single data--------------------------------------------------------------------------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) 
    {
        return bookService.getBookById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    //OR
    
    @GetMapping("/{title}")
    public ResponseEntity<Book> getBookByTitle(@PathVariable String title) 
    {
        return bookService.getBookByTitle(title)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
    
//ADD--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    @PostMapping
    public Book addBook(@RequestBody Book book)
    { 
    	return bookService.addBook(book);
    }

    
//UPDATE------------------------------------------------------------------------------------------------------------------------------------------------
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) 
    {
        return bookService.getBookById(id)
            .map(existingBook -> {
                book.setId(id);
                return ResponseEntity.ok(bookService.updateBook(book));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    
//DELETE------------------------------------------------------------------------------------------------------------------------------------------------
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) 
    { 
    	bookService.deleteBook(id); 
    	return ResponseEntity.ok("Book with ID " + id + " has been successfully deleted.");
    }
    
    
}
