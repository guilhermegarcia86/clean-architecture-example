package com.gogo.powerrangers.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gogo.powerrangers.SpringJdbcUserRepository;
import com.gogo.powerrangers.UserController;
import com.gogo.powerrangers.usecase.CreateUser;
import com.gogo.powerrangers.usecase.SearchUser;
import com.gogo.powerrangers.usecase.port.UserRepository;

@Configuration
public class SpringBootConfig {

    @Bean
    public UserRepository dataBase(){
        return new SpringJdbcUserRepository();
    }

    @Bean
    public CreateUser createUser(){
        return new CreateUser(this.dataBase());
    }
    
    @Bean
    public SearchUser searchUser() {
    	return new SearchUser(this.dataBase());
    }

    @Bean
    public UserController userController(){
        return new UserController(this.createUser(), this.searchUser());
    }
}
