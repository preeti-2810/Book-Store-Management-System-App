package com.book.store.management.app.controllers;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Category;
import com.book.store.management.app.exceptions.BookAlreadyExistException;
import com.book.store.management.app.exceptions.BookNotFoundException;
import com.book.store.management.app.exceptions.CategoryNotFoundException;
import com.book.store.management.app.repo.IBookRepository;
import com.book.store.management.app.repo.ICategoryRepository;
import com.book.store.management.app.services.BookService;

@RestController
public class BookController {
 private static final Logger log = LoggerFactory.getLogger(BookController.class);
	
	
	@Autowired
	BookService bookservice;
	
	@PostMapping("/books")
	@ResponseStatus(code = HttpStatus.CREATED)
	@Transactional
	
	public Book createBook(@RequestBody Book b)
	{
		log.info("Creating a book");	
		return bookservice.createBook(b);
		
	}
	
	@GetMapping("/books/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Book> listAllBook(){
		log.info("Finding the list of books");
		return bookservice.listAllBook();
	}
	
	@DeleteMapping("/books/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Book deleteBook(@RequestBody Book b) {
		log.info("Delete the books");
		return bookservice.deleteBook(b);
	}
	
	@PutMapping("/books")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public Book editBook(@RequestBody Book b) {
		log.info("Editing the books");

				
		return bookservice.editBook(b);
	}
	
	@GetMapping("/books/{id}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public Book viewBook(@RequestBody Book b) {
		log.info("viewing the book");
		return bookservice.viewBook(b);
	}
	

	
	@GetMapping("/books/category/{categoryName}")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Book> listBooksByCategory(@PathVariable String categoryName){
		log.info("Listing the books by category");
		return bookservice.listBooksByCategory(categoryName);
		
	}
	@GetMapping("/books/best")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Book> listBestSellingBook() {
		log.info("Listing the best selling book");
		return bookservice.listBestSellingBook();
	}
	
}
