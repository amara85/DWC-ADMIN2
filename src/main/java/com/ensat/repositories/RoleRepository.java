package com.ensat.repositories;

import com.ensat.entities.Role;

import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Integer> {

	Role findByNom(String nom);
	
}