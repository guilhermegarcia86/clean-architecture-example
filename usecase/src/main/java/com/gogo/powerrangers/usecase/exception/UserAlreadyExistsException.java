package com.gogo.powerrangers.usecase.exception;

public class UserAlreadyExistsException extends RuntimeException{

    public UserAlreadyExistsException(String email) {
        super(email);
    }
}
