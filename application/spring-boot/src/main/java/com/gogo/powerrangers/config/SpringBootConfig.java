package com.gogo.powerrangers.config;

import com.gogo.powerrangers.SpringJdbcUserRepository;
import com.gogo.powerrangers.UserController;
import com.gogo.powerrangers.usecase.CreateUser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class SpringBootConfig {

    @Bean
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql").build();
    }

    @Bean
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(this.dataSource());
    }

    @Bean
    public SpringJdbcUserRepository dataBase(){
        return new SpringJdbcUserRepository(this.jdbcTemplate());
    }

    @Bean
    public CreateUser createUser(){
        return new CreateUser(this.dataBase());
    }

    @Bean
    public UserController userController(){
        return new UserController(this.createUser());
    }
}
