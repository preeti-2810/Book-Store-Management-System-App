package com.book.store.management.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.store.management.app.entities.User;



@Repository
public interface ILoginRepository extends JpaRepository<User,Integer>{

	public User findByEmail(String email);
}
