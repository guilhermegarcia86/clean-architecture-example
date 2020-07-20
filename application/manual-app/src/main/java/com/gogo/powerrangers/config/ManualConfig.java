package com.gogo.powerrangers.config;

import com.gogo.powerrangers.db.InMemoryUserRepository;
import com.gogo.powerrangers.usecase.CreateUser;
import com.gogo.powerrangers.usecase.SearchUser;
import com.gogo.powerrangers.usecase.port.UserRepository;

public class ManualConfig {

    private final UserRepository dataBase = new InMemoryUserRepository();

    public CreateUser createUser(){
        return new CreateUser(dataBase);
    }
    
    public SearchUser searchUser() {
    	return new SearchUser(dataBase);
    }
}
