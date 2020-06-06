package com.gogo.powerrangers.config;

import com.gogo.powerrangers.HibernateUserRepository;
import com.gogo.powerrangers.db.InMemoryUserRepository;
import com.gogo.powerrangers.usecase.CreateUser;
import com.gogo.powerrangers.usecase.SearchUser;
import com.gogo.powerrangers.usecase.port.UserRepository;

public class ManualConfig {

    private final InMemoryUserRepository dataBase = new InMemoryUserRepository();
    
	public final UserRepository repository() {
		return new HibernateUserRepository();
	}

    public CreateUser createUser(){
        return new CreateUser(repository());
    }
    
    public SearchUser searchUser() {
    	return new SearchUser(repository());
    }
}
