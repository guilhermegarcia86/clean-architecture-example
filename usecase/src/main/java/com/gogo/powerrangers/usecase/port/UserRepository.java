package com.gogo.powerrangers.usecase.port;

import com.gogo.powerrangers.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User create(User user);

    Optional<User> findByEmail(String email);

    Optional<List<User>> findAllUsers();
}
