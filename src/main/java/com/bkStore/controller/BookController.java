package com.bkStore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bkStore.model.Book;
import com.bkStore.model.MyBookList;
import com.bkStore.services.BookService;
import com.bkStore.services.MyBookListService;

@Controller
public class BookController {

	@Autowired
	BookService bkservice;
	
	@Autowired
	private MyBookListService myBookListService;
	
	
	//home page API.
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	
	
	@GetMapping("/available_books")
	public ModelAndView getAllBook()
	{
		List<Book> list = bkservice.getAllBook();
		
		return new ModelAndView("bookList", "book",list);
	}
	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b)
	{
		bkservice.save(b);
		return  "redirect:/available_books";
	}
	
	
	@GetMapping("/my_books")
	public String myBooks() {
		
		return "myBooks";
	}
	
	
	@RequestMapping("/myList/{id}")
	public String getMyList(@PathVariable int id)
	{
		Book b = bkservice.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(),b.getName(), b.getAuthor(), b.getPrice());
		myBookListService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	
	
	
	
	
	
	//my custom api
	@GetMapping("/books")
	public String books() {
		return "books";
	}
}
