package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.*;


@Controller
public class BookstoreController {
        @Autowired
        private BookRepository repository;
        
        @Autowired
        private CategoryRepository cRepository;
        
        @RequestMapping(value="/login")
        public String login() {	
            return "login";
        }	

        @RequestMapping(value= {"/", "/booklist"})
        public String bookList(Model model) {
        model.addAttribute("books", repository.findAll());
        model.addAttribute("categories", cRepository.findAll());
        return "booklist";
        }
        
        @org.springframework.security.access.prepost.PreAuthorize("hasAuthority('ADMIN')")
        @RequestMapping(value= "/delete/{id}", method = RequestMethod.GET)
        public String deleteBook(@PathVariable("id") Long BookId, Model model) {
        	repository.deleteById(BookId);
        	return "redirect:/booklist";
        }
        
        @RequestMapping(value= "/addbook")
        public String addBook(Model model) {
        	model.addAttribute("newBook", new Book());
        	model.addAttribute("categories", cRepository.findAll());
        	return "addBook";
        }
        @org.springframework.security.access.prepost.PreAuthorize("hasAuthority('ADMIN')")
        @RequestMapping(value= "/editBook/{id}", method = RequestMethod.GET)
        public String editBook(@PathVariable("id") Long BookId, Model model) {
        	model.addAttribute("editBook", repository.findById(BookId));
        	model.addAttribute("categories", cRepository.findAll());
        	return "editBook";
        }
        
        @RequestMapping(value = "saveBook", method = RequestMethod.POST)
    	public String saveBook(Book book) {
    		repository.save(book);
    		return "redirect:/booklist";
    	}
}