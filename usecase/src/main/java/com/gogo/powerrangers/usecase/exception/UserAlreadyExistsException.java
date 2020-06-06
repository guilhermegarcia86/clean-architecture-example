package com.gogo.powerrangers.usecase.exception;

public class UserAlreadyExistsException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserAlreadyExistsException(String email) {
        super(email);
    }
}
