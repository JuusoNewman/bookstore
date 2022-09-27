package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@RestController
public class RestBookstoreController {
	@Autowired BookRepository brepository;
	
	// RESTful service to get all books
    @RequestMapping(value="/books", method = RequestMethod.GET)
    public List<Book> booktListRest() {	
        return (List<Book>) brepository.findAll();
    }
    
    // RESTful service to get student by id
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public Optional<Book> findSBookRest(@PathVariable("id") Long bookId) {	
    	return brepository.findById(bookId);
    }
    
    //RESTful service to adding book information   
    @RequestMapping(value="/books", method = RequestMethod.POST)
    	public Book newBook(@RequestBody Book newBook){
    		return brepository.save(newBook);
    }
    
}
