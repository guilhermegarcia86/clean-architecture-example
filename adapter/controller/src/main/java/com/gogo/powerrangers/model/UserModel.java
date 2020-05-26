package com.gogo.powerrangers.model;

import com.gogo.powerrangers.entity.User;
import lombok.Data;

@Data
public class UserModel {

    private String name;
    private String email;
    private int age;
    private String personality;
    private String ranger;

    public static UserModel mapToUserModel(User user) {

        var userModel = new UserModel();
        userModel.name = user.getName();
        userModel.email = user.getEmail();
        userModel.age = user.getAge();
        userModel.personality = user.getPersonality().getPersonality();
        userModel.ranger = user.getRanger();

        return userModel;
    }

    public static User mapToUser(UserModel userModel) {
        //@formatter:off
        return User.builder().name(userModel.getName())
                             .age(userModel.getAge())
                             .email(userModel.getEmail())
                             .personality(userModel.getPersonality())
                             .build();
        //@formatter:on
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", personality='" + personality + '\'' +
                ", ranger='" + ranger + '\'' +
                '}';
    }
}
