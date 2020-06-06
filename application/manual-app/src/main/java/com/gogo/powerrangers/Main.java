package com.gogo.powerrangers;

import com.gogo.powerrangers.config.ManualConfig;
import com.gogo.powerrangers.model.UserModel;

public class Main {

    public static void main(String[] args) {

        var config = new ManualConfig();
        var createUser = config.createUser();
        var searchUser = config.searchUser();
        var controller = new UserController(createUser, searchUser);

        var userModel = new UserModel();
        userModel.setName(args[0]);
        userModel.setEmail(args[1]);
        userModel.setAge(Integer.parseInt(args[2]));
        userModel.setPersonality(args[3]);

        final var userCreated = controller.createUser(userModel);

        System.out.println(userCreated);
    }
}
