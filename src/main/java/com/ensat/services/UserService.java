package com.ensat.services;

import com.ensat.entities.User;

public interface UserService {

    Iterable<User> listAllUsers();

    User findByUsername(String username);

    User saveUser(User User);

    void deleteUser(User User);

}
