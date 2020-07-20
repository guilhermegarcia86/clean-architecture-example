package com.gogo.powerrangers.endpoint;

import com.gogo.powerrangers.UserController;
import com.gogo.powerrangers.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/powerrangers")
public class SearchUserController {

    @Autowired
    private UserController userController;

    @GetMapping("user")
    public ResponseEntity<UserModel> getUser(@RequestParam(name = "email") String email){
        return ResponseEntity.ok(userController.searchByEmail(email));
    }
}
