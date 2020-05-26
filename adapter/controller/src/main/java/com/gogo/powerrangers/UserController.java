package com.gogo.powerrangers;

import com.gogo.powerrangers.model.UserModel;
import com.gogo.powerrangers.usecase.CreateUser;

public class UserController {

    private final CreateUser createUser;

    public UserController(CreateUser createUser){
        this.createUser = createUser;
    }

    public UserModel createUser(UserModel userModel){

        var user = createUser.create(UserModel.mapToUser(userModel));

        return UserModel.mapToUserModel(user);
    }

}
