package com.example.Bookstore;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookrepo;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	
	@Test
	public void findBook() {
		Book book = bookrepo.findById((long) 8).get();
		assertEquals(book.getTitle(), "Moi moi");
	}
	
	
	@Test
	public void insertNewBook() {
		Book book = new Book(null, "Yolo", "McYarborough", null, 2020, 0, null);
		bookrepo.save(book);
		assertNotNull(book.getId());
	}
	
}
