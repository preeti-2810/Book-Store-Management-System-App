package com.book.store.management.app.controllers;

import java.util.List;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.store.management.app.entities.Category;
import com.book.store.management.app.exceptions.CategoryAlreadyExistException;
import com.book.store.management.app.exceptions.CategoryNotFoundException;
import com.book.store.management.app.repo.ICategoryRepository;
import com.book.store.management.app.services.CategoryService;

@RestController
public class CategoryController {
	private static final Logger log = LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	CategoryService categoryService;

	@PostMapping("/categories")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Category addCategory (@RequestBody Category category) {
		log.info("Adding the Category");
		return categoryService.addCategory(category.getCategoryName());
	}

	@PutMapping("/categories/{CategoryName}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	@Transactional
	public Category editCategory(@RequestBody Category category) {
		log.info("Editing Category");


		return categoryService.editCategory(category);
	}

	@GetMapping("/categories/list")
	@ResponseStatus(code = HttpStatus.FOUND)
	public List<Category> viewAllCategories() {
		log.info("Viewing all categories");
		return categoryService.viewAllCategories();
	}

	@DeleteMapping("/categories/{categoryName}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public Category removeCategory(@RequestBody Category category) {
		log.info("Removing category");
		return categoryService.removeCategory(category);
	}

}