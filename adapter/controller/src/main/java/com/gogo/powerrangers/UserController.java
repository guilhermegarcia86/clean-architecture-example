package com.gogo.powerrangers;

import com.gogo.powerrangers.presenter.UserPresenter;
import com.gogo.powerrangers.usecase.CreateUser;
import com.gogo.powerrangers.usecase.SearchUser;

public class UserController {

    private final CreateUser createUser;
    private final SearchUser searchUser;

    public UserController(CreateUser createUser, SearchUser searchUser){
        this.createUser = createUser;
        this.searchUser = searchUser;
    }

    public UserPresenter createUser(UserPresenter userPresenter){

        var user = createUser.create(UserPresenter.mapToUser(userPresenter));

        return UserPresenter.mapToUserModel(user);
    }
    
    public UserPresenter searchByEmail(String email) {
    	
    	var user = searchUser.search(email);
    	
    	return UserPresenter.mapToUserModel(user);
    }

}
