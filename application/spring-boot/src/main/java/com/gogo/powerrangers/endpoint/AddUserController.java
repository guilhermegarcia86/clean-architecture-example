package com.gogo.powerrangers.endpoint;

import com.gogo.powerrangers.UserController;
import com.gogo.powerrangers.presenter.UserPresenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/powerrangers")
public class AddUserController {

    @Autowired
    private UserController userController;

    @PostMapping("add")
    public ResponseEntity<UserPresenter> addUser(@RequestBody UserPresenter userPresenter){
        return ResponseEntity.ok(userController.createUser(userPresenter));
    }
}
