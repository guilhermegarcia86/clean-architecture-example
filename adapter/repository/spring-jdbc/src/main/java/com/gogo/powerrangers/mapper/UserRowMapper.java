package com.gogo.powerrangers.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.gogo.powerrangers.entity.UserEntity;

public class UserRowMapper implements RowMapper<UserEntity> {

    @Override
    public UserEntity mapRow(ResultSet resultSet, int i) throws SQLException {

        var entity = new UserEntity();

        entity.setId(resultSet.getString("ID"));
        entity.setAge(resultSet.getInt("AGE"));
        entity.setEmail(resultSet.getString("EMAIL"));
        entity.setRanger(resultSet.getString("RANGER"));
        entity.setName(resultSet.getString("NAME"));
        entity.setPersonality(resultSet.getString("PERSONALITY"));

        return entity;
    }
}
