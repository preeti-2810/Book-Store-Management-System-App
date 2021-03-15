package com.book.store.management.app.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.store.management.app.entities.Category;
import com.book.store.management.app.exceptions.CategoryAlreadyExistException;
import com.book.store.management.app.exceptions.CategoryNotFoundException;
import com.book.store.management.app.repo.ICategoryRepository;
import com.book.store.management.app.serviceInterface.ICategoryService;



@Service
public class CategoryService implements ICategoryService{
	
	@Autowired
	ICategoryRepository categoryRepository;

	@Override
	public Category addCategory(String categoryName) {
		
		Category category = categoryRepository.findByCategoryName(categoryName);
		
		if(category == null) {
		
			categoryRepository.save(new Category(categoryName));
			
		}
		
		else
			throw new CategoryAlreadyExistException("Category already exist");
		
		return category;
	}

	@Override
	@Transactional
	public Category editCategory(Category category) {

		Category cat = categoryRepository.findByCategoryName(category.getCategoryName());
		
		if(cat == null) 
			throw new CategoryNotFoundException("There is no category in the repository with the name " + category.getCategoryName());
			
		else
			cat.setCategoryName(category.getCategoryName());
		
		return cat;
	}

	@Override
	public List<Category> viewAllCategories() {
		
		List<Category> list = categoryRepository.findAll();
		
		if(list.isEmpty())
			throw new CategoryNotFoundException("There is no category in the repository");
		
		return list;
	}

	@Override
	public Category removeCategory(Category category) {

		Category cat  = categoryRepository.findByCategoryName(category.getCategoryName());
		
		if(cat==null)
			throw new CategoryNotFoundException("There is no category in the repository to delete with the name " + category.getCategoryName());
		else
			categoryRepository.delete(cat);
		
		return cat;
	}

}
