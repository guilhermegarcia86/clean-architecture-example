package com.gogo.powerrangers.entity;

import lombok.Data;

@Data
public class UserEntity {

    private Integer id;
    private String name;
    private String email;
    private int age;
    private String personality;
    private String ranger;

    public static User toUser(UserEntity entity){
        var user = User.builder().name(entity.getName()).age(entity.getAge())
                .email(entity.getEmail()).personality(entity.getPersonality()).build();

        return user;
    }

}
