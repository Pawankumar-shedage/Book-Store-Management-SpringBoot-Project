package com.bkStore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bkStore.model.Book;

//interface to create.
public interface BookRepository extends JpaRepository<Book , Integer> {
	
	
}
