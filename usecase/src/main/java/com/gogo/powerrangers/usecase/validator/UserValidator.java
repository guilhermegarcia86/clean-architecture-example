package com.gogo.powerrangers.usecase.validator;

import com.gogo.powerrangers.entity.User;
import com.gogo.powerrangers.usecase.exception.UserValidationException;

import static java.util.Objects.isNull;

public class UserValidator {

    public static void validateCreateUser(final User user) {
        if(isNull(user)) {
            throw new UserValidationException("Usuario nao pode ser null");
        }
        if(user.getAge() < 18) {
            throw new UserValidationException("Usuario deve ser maior de 18 anos");
        }
    }

}
