package com.ensat.services;

import com.ensat.entities.Role;
import com.ensat.entities.User;

public interface RoleService {

    Iterable<Role> listAllRoles();

    Role saveRole(Role Role);

    void deleteRole(Role Role);
    
    Role findByNom(String nom);

}
