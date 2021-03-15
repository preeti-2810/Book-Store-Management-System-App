package com.book.store.management.app.serviceInterface;

import java.util.List;

import com.book.store.management.app.entities.Category;




public interface ICategoryService {

	public Category addCategory(String categoryName);
	public Category editCategory(Category category);
	public List<Category> viewAllCategories();
	public Category removeCategory(Category category);
}
