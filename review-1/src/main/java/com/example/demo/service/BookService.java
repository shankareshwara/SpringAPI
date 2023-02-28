package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.Book;
import com.example.demo.repository.bookRepository;
@Service
public class BookService {
	@Autowired
	bookRepository repository;
	public String addBook(Book book) 
	{
		repository.save(book);
		return "Book is Added";
	}
	public List<Book> getBook()
	{
		return repository.findAll();
	}
	
	public String updateBook(Book book)
	{
		repository.save(book);
		return " Book is Updated ";
	}
	
	public String deleteBookById(int id) {
	    repository.deleteById(id);
	    return "Book Removed";
	}
	
	public List<Book> getBookSorted(String field)
	{
		return repository.findAll(Sort.by(Sort.Direction.ASC, field));
	}
	public List<Book> getBookWithPagination(@PathVariable int offset, @PathVariable int pageSize)
	{
		Page<Book> page=repository.findAll(PageRequest.of(offset,pageSize));
		return page.getContent();
	}
	public List<Book> getBookWithSortingAndPagination(int offset,int pageSize,String field)
	{
		Pageable paging = PageRequest.of(offset,pageSize,Sort.by(field));
		Page<Book> page=repository.findAll(paging);
		return page.getContent();
	}

}