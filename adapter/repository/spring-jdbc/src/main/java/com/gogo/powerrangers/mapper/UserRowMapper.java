package com.gogo.powerrangers.mapper;

import com.gogo.powerrangers.entity.Personality;
import com.gogo.powerrangers.entity.UserEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        UserEntity entity = new UserEntity();

        entity.setId(resultSet.getInt("ID"));
        entity.setAge(resultSet.getInt("AGE"));
        entity.setEmail(resultSet.getString("EMAIL"));
        entity.setRanger(resultSet.getString("RANGER"));
        entity.setName(resultSet.getString("NAME"));
        entity.setPersonality(resultSet.getString("PERSONALITY"));

        return entity;
    }
}
