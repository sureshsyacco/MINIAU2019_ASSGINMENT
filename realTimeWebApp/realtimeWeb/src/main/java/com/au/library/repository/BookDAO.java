package com.au.library.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.au.library.model.Book;



@Repository
public class BookDAO {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Book> all() {
		return jdbcTemplate.query("select * from books",(rs,i)->{
			return new Book(rs.getString("id"),
					rs.getString("title"),
					rs.getString("author"),
					rs.getDouble("price"),
					rs.getString("descr"));
		});

	}
	
	
	public Book byId(String bookId) {
		return jdbcTemplate.queryForObject("select * from books where id="+bookId, (rs,i)->{
			return new Book(rs.getString("id"),
					rs.getString("title"),
					rs.getString("author"),
					rs.getDouble("price"),
					rs.getString("descr"));
		});

	}
	
	public Book create(Book book)
	{
		jdbcTemplate.update("insert into books(id,descr,title,author,price)"
				+"values(?,?,?,?,?)",
				 book.getId(),
				book.getDescription(),
				book.getBookName(),
				book.getAuthorName(),
				book.getPrice());
		return book;
		
	}
	
	
	
	public Book cart(Book book) {
		jdbcTemplate.update("insert into cart(id,descr,title,author,price"+
	"values(?,?,?,?,?);",
				book.getId(),
				book.getDescription(),
				book.getBookName(),
				book.getAuthorName(),
				book.getPrice());
			System.out.println(	book.getId()+
				book.getBookName()+
				book.getAuthorName()+
				
				book.getDescription()+
				book.getPrice());
	
		return book;
		
	}
	public List<Book> AllCart()
	{
		return jdbcTemplate.query("select * from cart", (rs,i)->{
			
			return new Book(rs.getString("id"),
					rs.getString("bookName"),rs.getString("authorName"),
					rs.getDouble("Price"),rs.getString("Description"));
		
	});
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
