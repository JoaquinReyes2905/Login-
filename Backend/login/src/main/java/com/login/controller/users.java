package com.login.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.login.Repo.*;
import com.login.models.*;

class users {
	@RestController
	public class usersController {
		
		@Autowired
	    private BookRepository bookRepository;
	 
	    @GetMapping("/")
	    public List<Book> getAllBooks() {
	        return bookRepository.findAll();
	    }
	 
	    @GetMapping("/{id}")
	    public Book getBookById(@PathVariable Long id) {
	        return bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
	    }
	 
	    @PostMapping("/")
	    public Book createBook(@Valid @RequestBody Book book) {
	        return bookRepository.save(book);
	    }
	 
	    @PutMapping("/{id}")
	    public Book updateBook(@PathVariable Long id, @Valid @RequestBody Book bookDetails) {
	        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
	 
	        book.setTitle(bookDetails.getTitle());
	        book.setAuthor(bookDetails.getAuthor());
	        book.setIsbn(bookDetails.getIsbn());
	 
	        return bookRepository.save(book);
	    }
	 
	    @DeleteMapping("/{id}")
	    public ResponseEntity<?> deleteBook(@PathVariable Long id) {
	        Book book = bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Book not found"));
	 
	        bookRepository.delete(book);
	 
	        return ResponseEntity.ok().build();
	    }
	}
}
