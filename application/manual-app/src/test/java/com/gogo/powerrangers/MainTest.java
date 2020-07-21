package com.gogo.powerrangers;

import com.gogo.powerrangers.config.ManualConfigTest;
import com.gogo.powerrangers.presenter.UserPresenter;
import com.gogo.powerrangers.usecase.exception.UserAlreadyExistsException;
import com.gogo.powerrangers.usecase.exception.UserValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    private ManualConfigTest config;
    private UserPresenter userPresenter;
    private UserController controller;

    @BeforeEach
    void setup(){
        config = new ManualConfigTest();
        controller = new UserController(config.createUser(), config.searchUser());

        userPresenter = new UserPresenter();
        userPresenter.setName("Guilherme");
        userPresenter.setEmail("guilherme.garcia@gmail.com");
        userPresenter.setAge(34);
        userPresenter.setPersonality("Entusiasmo");
    }

    @Test
    void manualAppSuccess(){

        var userModelCreated = controller.createUser(this.userPresenter);

        assertNotNull(userModelCreated);
        assertEquals("Preto", userModelCreated.getRanger());

    }

    @Test
    void manualAppValidationAge(){
        this.userPresenter.setAge(17);

        var exception = assertThrows(UserValidationException.class, () -> controller.createUser(this.userPresenter));

        assertEquals("Usuario deve ser maior de 18 anos", exception.getMessage());

    }

    @Test
    void manualAppValidationNull(){
        var exception = assertThrows(NullPointerException.class, () -> controller.createUser(null));

        assertNull(exception.getMessage());
    }

    @Test
    void manualAppValidationUserAlreadyExists(){
        var userCreated = controller.createUser(this.userPresenter);

        var exception = assertThrows(UserAlreadyExistsException.class, () -> controller.createUser(userCreated));

        assertEquals("guilherme.garcia@gmail.com", exception.getMessage());

    }
}
