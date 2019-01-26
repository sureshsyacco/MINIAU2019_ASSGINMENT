package com.au.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.au.library.model.Book;
import com.au.library.repository.BookDAO;

@RestController
public class BooksController {
	
	@Autowired
	BookDAO bookDao;
	
	@RequestMapping(value="/search",method=RequestMethod.GET,produces="application/json")
	public List<Book> getAll()
	{
//		List<Book> books=new ArrayList<>();
//		books.add(new Book("1","Marvel","stanlee",222,"all super heroes"));
		return bookDao.all();
	}
	
	
	
	@RequestMapping(value="/books/{bookId}/get",method=RequestMethod.GET,produces="application/json")
	public Book getBookById(@PathVariable(value="bookId") String bookId)
	{
		//List<Book> books=new ArrayList<>();
		//return new Book("1","Marvel","stanlee",222,"all super heroes");
		return bookDao.byId(bookId);
	}
	
	@RequestMapping(value="/books/create",method=RequestMethod.POST,consumes="application/json")
	public Book create(@RequestBody Book bookTocCreate)
	{
		return bookDao.create(bookTocCreate);
		
	}
	
	
	@RequestMapping(value="/bookscart" , method=RequestMethod.POST,produces="application/json")
	public Book cartAdd(@RequestBody Book book )
	{
		
		System.out.println(	book.getId()+
				book.getBookName()+
				book.getAuthorName()+
				
				book.getDescription()+
				book.getPrice());
	
		
				
				return	bookDao.cart(book);	
				}
	@RequestMapping(value="/bookscart" , method=RequestMethod.GET, produces="application/json")
	public List<Book> gAll()
	{
		List<Book> books=new ArrayList<Book>();
			
				books=bookDao.AllCart();
				return books;
	}
	


}
