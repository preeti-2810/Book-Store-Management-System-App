package com.book.store.management.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.store.management.app.entities.Category;




@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer>{

	public Category findByCategoryName(String name);
	
}
