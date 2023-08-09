package com.bkStore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bkStore.model.MyBookList;
import com.bkStore.repository.MyBookRepo;

@Service
public class MyBookListService {
	
	@Autowired 		//to automatically inject class dependencies.
	MyBookRepo myBookRepository;
	
	public void saveMyBooks(MyBookList book)
	{
		myBookRepository.save(book);
	}
	
	
	
}
