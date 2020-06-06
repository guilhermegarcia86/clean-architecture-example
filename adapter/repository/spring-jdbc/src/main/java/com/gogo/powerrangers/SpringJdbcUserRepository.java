package com.gogo.powerrangers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import com.gogo.powerrangers.entity.User;
import com.gogo.powerrangers.entity.UserEntity;
import com.gogo.powerrangers.mapper.UserRowMapper;
import com.gogo.powerrangers.usecase.port.UserRepository;

public class SpringJdbcUserRepository implements UserRepository {
	
	private JdbcTemplate jdbcTemplate;
    
    public DataSource dataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema.sql").build();
    }
    
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(this.dataSource());
    }
    
    public SpringJdbcUserRepository() {
    	this.jdbcTemplate = this.jdbcTemplate();
    }

    @Override
    public User create(User user) {

        //@formatter:off
        String sql = new StringBuilder().append("INSERT INTO  ")
                                        .append(" USER(id, name, age, email, personality, ranger) ")
                                        .append(" VALUES(?, ?, ?, ?, ?, ?)").toString();
        //@formatter:on

        jdbcTemplate.update(sql, UUID.randomUUID().toString(), user.getName(), user.getAge(), user.getEmail(), user.getPersonality().getPersonality(), user.getRanger());

        return user;
    }

    @Override
    public Optional<User> findByEmail(String email) {

        String sql = "SELECT id, name, age, email, personality, ranger FROM USER WHERE email = ?";

        try {
            UserEntity userEntity = jdbcTemplate.queryForObject(sql, new UserRowMapper(), email);

            User user = UserEntity.toUser(userEntity);

            return Optional.of(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<User>> findAllUsers() {

        String sql = "SELECT id, name, age, email, personality, ranger FROM USER";

        List<UserEntity> userEntityList = jdbcTemplate.query(sql, new UserRowMapper());

        List<User> userList = userEntityList.stream().map(entity -> {
            return UserEntity.toUser(entity);
        }).collect(Collectors.toList());

        return Optional.of(userList);
    }
}
