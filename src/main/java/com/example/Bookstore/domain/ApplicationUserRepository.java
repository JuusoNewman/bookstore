package com.example.Bookstore.domain;
import org.springframework.data.repository.CrudRepository;

	public interface ApplicationUserRepository extends CrudRepository<Users, Long> {
		
	Users findByUsername(String username);
	
	}
