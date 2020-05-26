package com.gogo.powerrangers.db;

import com.gogo.powerrangers.entity.User;
import com.gogo.powerrangers.usecase.port.UserRepository;

import java.util.*;

public class InMemoryUserRepository implements UserRepository {

    private final Map<String, User> inMemoryDb = new HashMap<>();

    @Override
    public User create(User user) {
        inMemoryDb.put(user.getEmail(), user);
        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return inMemoryDb.values().stream().filter(user -> user.getEmail().equals(email)).findAny();
    }

    @Override
    public Optional<List<User>> findAllUsers() {
        return Optional.of(new ArrayList<>(inMemoryDb.values()));
    }
}
