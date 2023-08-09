package com.bkStore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkStore.model.Book;
import com.bkStore.repository.BookRepository;

@Service
public class BookService {
	
	
	@Autowired
	BookRepository bookRepository;
	
	public void save(Book b)
	{
		bookRepository.save(b);
	}
	
	
	//returning the list of data.
	
	public  List<Book> getAllBook()
	{
		return bookRepository.findAll();
	}
	
	public Book getBookById(int id)
	{
		return bookRepository.findById(id).get();
	}
}
