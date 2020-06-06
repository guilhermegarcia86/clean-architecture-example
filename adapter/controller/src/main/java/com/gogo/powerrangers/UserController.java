package com.gogo.powerrangers;

import com.gogo.powerrangers.model.UserModel;
import com.gogo.powerrangers.usecase.CreateUser;
import com.gogo.powerrangers.usecase.SearchUser;

public class UserController {

    private final CreateUser createUser;
    private final SearchUser searchUser;

    public UserController(CreateUser createUser, SearchUser searchUser){
        this.createUser = createUser;
        this.searchUser = searchUser;
    }

    public UserModel createUser(UserModel userModel){

        var user = createUser.create(UserModel.mapToUser(userModel));

        return UserModel.mapToUserModel(user);
    }
    
    public UserModel searchByEmail(String email) {
    	
    	var user = searchUser.search(email);
    	
    	return UserModel.mapToUserModel(user);
    }

}
