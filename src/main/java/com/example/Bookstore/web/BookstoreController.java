package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.*;


@Controller
public class BookstoreController {
        @Autowired
        private BookRepository repository;

        @RequestMapping(value= {"/", "/booklist"})
        public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        return "booklist";
        }
        
        @RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
        public String deleteBook(@PathVariable("id") Long BookId, Model model) {
        	repository.deleteById(BookId);
        	return "redirect:booklist";
        }
        
        @RequestMapping(value= "/addbook")
        public String addBook(Model model) {
        	model.addAttribute("newBook", new Book());
        	return "addBook";
        }
        
        @RequestMapping(value= "/editbook/{id}")
        public String editBook(@PathVariable("id") Long BookId, Model model) {
        	model.addAttribute("editBook", repository.findById(BookId));
        	return "editBook";
        }
        
        @PostMapping("saveBook")
    	public String saveBook(Book book) {
    		repository.save(book);
    		return "redirect:booklist";
    	}
}