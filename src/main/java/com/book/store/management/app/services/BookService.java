package com.book.store.management.app.services;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.management.app.entities.Book;
import com.book.store.management.app.entities.Category;
import com.book.store.management.app.exceptions.BookAlreadyExistException;
import com.book.store.management.app.exceptions.BookNotFoundException;
import com.book.store.management.app.exceptions.CategoryNotFoundException;
import com.book.store.management.app.repo.ICategoryRepository;
import com.book.store.management.app.serviceInterface.IBookService;



import com.book.store.management.app.repo.IBookRepository;




@Service
public class BookService  implements IBookService{

	@Autowired
	IBookRepository  bookRepository;
	
	@Autowired
	ICategoryRepository categoryRepository;
	
	
	
	public Book createBook( Book b)
	{
	
		Book book = bookRepository.findByTitleAndAuthor(b.getTitle(),b.getAuthor());
		
		if(book == null) {
		
			bookRepository.save(b);
			
		}
		
		else
			throw new BookAlreadyExistException("Book with title " + b.getTitle() + " by the author " + b.getAuthor() + " already exist");
	
		return b;
		
	}
	
	public List<Book> listAllBook(){
		
		List<Book> list = bookRepository.findAll();
		
		if(list.isEmpty())
			throw new BookNotFoundException("There is no book in the repository");
		
		return list;
		
	}
	
	
	public Book deleteBook(Book b) {
		
		Book book  = bookRepository.findById(b.getBookId());
			
		if(book ==null)
			throw new BookNotFoundException("There is no book in the repository to delete with the id " + b.getBookId());
		
		else
			bookRepository.delete(book);
		
		return book;
	}
	
	@Transactional
	public Book editBook(Book b) {
		
		Book book = bookRepository.findById(b.getBookId());
		
		if(book == null) 
			throw new BookNotFoundException("There is no book in the repository with the id " + b.getBookId());
		else {
			book.setAuthor(b.getAuthor());
		}
				
		return book;
	}
	
	public Book viewBook(Book b) {
		
		Book book = bookRepository.findById(b.getBookId());
		
		if(book ==null) 
			throw new BookNotFoundException("There is no book in the repository with the id " + b.getBookId());
		
		return b;
	}
	
//	public Optional<Book> viewBook(int b) {
//		
//		Optional<Book> book = bookRepository.findById(b);
//		
//		if(!book.isPresent()) 
//			throw new BookNotFoundException("There is no book in the repository with the id " + b);
//		
//		return book;
//	}
	public List<Book> listBooksByCategory(String category){
		
		Category cat = categoryRepository.findByCategoryName(category);
		
		if(cat==null)
			throw new CategoryNotFoundException("There is no such category with the name " + category);
		
		List<Book> book  = bookRepository.findByCategory(cat);
		
		if(book.isEmpty())
			throw new BookNotFoundException("There is no book in the category " + category);
		
		return book;
		
	}

	@Override
	public List<Book> listBestSellingBook() {
		
		return bookRepository.listBestSellingBooks();
	}
		
		
	
}
