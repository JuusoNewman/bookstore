package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.Book;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookstoreDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			
			log.info("save a couple of books");
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Sciense Fiction"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Folk"));
			
			brepository.save(new Book(null, "A Farewell to Arms", "Ernest Hemingway", "1232323-21", 1929, 9.13, crepository.findByName("Sciense Fiction").get(0)));
			brepository.save(new Book(null, "Moi moi", "Joku heppu", "1232424-21", 1953, 1.13, crepository.findByName("Fantasy").get(0)));
			
			log.info("fetch all books");
			for (Book book : brepository.findAll()){
				log.info(book.toString());
			};
		};

	};
}
