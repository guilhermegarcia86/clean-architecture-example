package com.gogo.powerrangers;

import com.gogo.powerrangers.config.ManualConfigTest;
import com.gogo.powerrangers.model.UserModel;
import com.gogo.powerrangers.usecase.exception.UserAlreadyExistsException;
import com.gogo.powerrangers.usecase.exception.UserValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private ManualConfigTest config;
    private UserModel userModel;
    private UserController controller;

    @BeforeEach
    void setup(){
        config = new ManualConfigTest();
        controller = new UserController(config.createUser(), config.searchUser());

        userModel = new UserModel();
        userModel.setName("Guilherme");
        userModel.setEmail("guilherme.garcia@gmail.com");
        userModel.setAge(34);
        userModel.setPersonality("Entusiasmo");
    }

    @Test
    void manualAppSuccess(){

        var userModelCreated = controller.createUser(this.userModel);

        assertNotNull(userModelCreated);
        assertEquals("Preto", userModelCreated.getRanger());

    }

    @Test
    void manualAppValidationAge(){
        this.userModel.setAge(17);

        var exception = assertThrows(UserValidationException.class, () -> controller.createUser(this.userModel));

        assertEquals("Usuario deve ser maior de 18 anos", exception.getMessage());

    }

    @Test
    void manualAppValidationNull(){
        var exception = assertThrows(NullPointerException.class, () -> controller.createUser(null));

        assertNull(exception.getMessage());
    }

    @Test
    void manualAppValidationUserAlreadyExists(){
        var userCreated = controller.createUser(this.userModel);

        var exception = assertThrows(UserAlreadyExistsException.class, () -> controller.createUser(userCreated));

        assertEquals("guilherme.garcia@gmail.com", exception.getMessage());

    }
}
