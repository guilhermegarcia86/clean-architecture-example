package com.gogo.powerrangers.config;

import com.gogo.powerrangers.HibernateUserRepository;
import com.gogo.powerrangers.usecase.CreateUser;
import com.gogo.powerrangers.usecase.SearchUser;
import com.gogo.powerrangers.usecase.port.UserRepository;

public class VertxConfig {
	
	public final UserRepository repository() {
		return new HibernateUserRepository();
	}
	
	public final CreateUser createUser() {
		return new CreateUser(this.repository());
	}
	
	public final SearchUser searchUser() {
		return new SearchUser(this.repository());
	}

}
