package com.ensat.services;

import com.ensat.entities.Role;
import com.ensat.repositories.RoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Role service implement.
 */
@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
    private RoleRepository roleRepository;
	
    public void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    
	public Iterable<Role> listAllRoles() {
        return roleRepository.findAll();
    }

    public Role saveRole(Role Role) {
        return roleRepository.save(Role);
    }
    
    public void deleteRole(Role Role) {
        roleRepository.delete(Role);
    }

	@Override
	public Role findByNom(String nom) {
		return roleRepository.findByNom(nom);
	}
    
    

}
