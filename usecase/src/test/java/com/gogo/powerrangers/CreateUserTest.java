package com.gogo.powerrangers;

import com.gogo.powerrangers.config.InMemoryUserRepository;
import com.gogo.powerrangers.entity.User;
import com.gogo.powerrangers.usecase.CreateUser;
import com.gogo.powerrangers.usecase.exception.UserAlreadyExistsException;
import com.gogo.powerrangers.usecase.exception.UserValidationException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreateUserTest {

    private InMemoryUserRepository repository;
    private CreateUser createUser;
    private User user;

    @BeforeEach
    void setup() {
        user = User.builder().name("Guilherme").email("guilherme.garcia86@gmail.com").age(34).personality("Persistência").build();

        repository = new InMemoryUserRepository();
        createUser = new CreateUser(repository);

    }

    @Test
    void createUserSuccess() {

        var userCreated = createUser.create(user);

        var userFindByEmail = repository.findByEmail("guilherme.garcia86@gmail.com");

        assertEquals("Guilherme", userCreated.getName());
        assertNotNull(userFindByEmail.get());
        assertEquals("Verde", userFindByEmail.get().getRanger());

    }

    @Test
    void createdUserValidateAge() {
        user = User.builder().name("Guilherme").email("guilherme.garcia86@gmail.com").age(17).personality("Persistência").build();

        var exception = assertThrows(UserValidationException.class, () -> createUser.create(user));

        assertEquals("Usuario deve ser maior de 18 anos", exception.getMessage());
    }

    @Test
    void createdUserValidateNullObject() {
        var exception = assertThrows(UserValidationException.class, () -> createUser.create(null));

        assertEquals("Usuario nao pode ser null", exception.getMessage());
    }

    @Test
    void createdUserValidateAlreadyExistUser() {
        var userCreated = createUser.create(user);

        var exception = assertThrows(UserAlreadyExistsException.class, () -> createUser.create(userCreated));

        assertEquals("guilherme.garcia86@gmail.com", exception.getMessage());
    }

}
