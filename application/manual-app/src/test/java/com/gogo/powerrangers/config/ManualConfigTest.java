package com.gogo.powerrangers.config;

import com.gogo.powerrangers.db.InMemoryUserRepository;
import com.gogo.powerrangers.usecase.CreateUser;

public class ManualConfigTest {

    private final InMemoryUserRepository dataBase = new InMemoryUserRepository();

    public CreateUser createUser(){
        return new CreateUser(dataBase);
    }
}
