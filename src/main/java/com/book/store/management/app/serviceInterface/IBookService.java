package com.book.store.management.app.serviceInterface;

import java.util.List;

import com.book.store.management.app.entities.Book;



public interface IBookService {

	public Book createBook(Book b);
	public List<Book> listAllBook();
	public Book deleteBook(Book b);
	public Book editBook(Book b);
	public Book viewBook(Book b);
	public List<Book> listBooksByCategory(String category);
	public List<Book> listBestSellingBook();
}
