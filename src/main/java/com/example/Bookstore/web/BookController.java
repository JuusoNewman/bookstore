package com.example.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BookController {
	@RequestMapping("/index")
	@ResponseBody
	public String showIndexPage() {
		
		return "This is the index page";
	}
	
}
