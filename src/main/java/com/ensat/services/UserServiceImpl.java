package com.ensat.services;

import com.ensat.entities.User;
import com.ensat.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * User service implement.
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserRepository UserRepository;
	
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public void setUserRepository(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
    
	public Iterable<User> listAllUsers() {
        return UserRepository.findAll();
    }

    public User findByUsername(String username) {
        return UserRepository.findByUsername(username);
    }

    public User saveUser(User user) {
    	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return UserRepository.save(user);
    }

    public void deleteUser(String id) {
        UserRepository.delete(id);
    }
    
    public void deleteUser(User user) {
        UserRepository.delete(user);
    }
    
    

}
