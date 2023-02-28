package com.example.demo.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;
@RestController
public class BookController {
	@Autowired
	BookService service;
	
	@PostMapping("/book")
	public String add(@RequestBody Book book)
	{
		return service.addBook(book);
	}
	
	@GetMapping("/book")
	public List<Book> get()
	{
		return service.getBook();
	}
	@GetMapping("/book/{field}")
	public List<Book> idWithSort(@PathVariable String field)
	{
		return service.getBookSorted(field);
	}
	@PutMapping("/book")
	public String update(@RequestBody Book book)
	{
		return service.updateBook(book);
	}
	
	@DeleteMapping("/book")
		public String delete(@RequestParam int id)
		{
		return service.deleteBookById(id);
		}
	
	@GetMapping("/book/{offset}/{pageSize}")
	public List<Book> bookWithPagination(@PathVariable int offset,@PathVariable int pageSize)
	{
		return service.getBookWithPagination(offset, pageSize );
	}
	@GetMapping("/book/{offset}/{pageSize}/{field}")
	public List<Book> bookWithSortingAndPagination(@PathVariable int offset,@PathVariable int pageSize,@PathVariable String field)
	{
		return service.getBookWithSortingAndPagination(offset, pageSize,field );
	}
	
	

}