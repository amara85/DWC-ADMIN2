package com.ensat.repositories;

import com.ensat.entities.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {

	User findByUsername(String username);
	
}