package com.gogo.powerrangers.usecase;

import java.util.Optional;

import com.gogo.powerrangers.entity.User;
import com.gogo.powerrangers.usecase.exception.UserAlreadyExistsException;
import com.gogo.powerrangers.usecase.port.UserRepository;

public class SearchUser {
	
    private final UserRepository repository;

    public SearchUser(UserRepository repository) {
        this.repository = repository;
    }
    
    public User search(String email) {
    	
    	Optional<User> findByEmail = repository.findByEmail(email);
    	
    	if (!findByEmail.isPresent()) {
            throw new UserAlreadyExistsException(email);
        }
    	
    	return findByEmail.get();
    }

}
