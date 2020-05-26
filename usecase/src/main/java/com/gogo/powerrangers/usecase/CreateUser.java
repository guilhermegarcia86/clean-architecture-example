package com.gogo.powerrangers.usecase;

import com.gogo.powerrangers.entity.User;
import com.gogo.powerrangers.usecase.exception.UserAlreadyExistsException;
import com.gogo.powerrangers.usecase.port.UserRepository;
import com.gogo.powerrangers.usecase.validator.UserValidator;

public class CreateUser {

    private final UserRepository repository;

    public CreateUser(UserRepository repository) {
        this.repository = repository;
    }

    public User create(final User user) {

        UserValidator.validateCreateUser(user);
        if (repository.findByEmail(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException(user.getEmail());
        }

        var createdUser = repository.create(user);

        return createdUser;
    }
}
