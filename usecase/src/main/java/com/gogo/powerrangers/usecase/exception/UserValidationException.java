package com.gogo.powerrangers.usecase.exception;

public class UserValidationException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserValidationException(String msg) {
        super(msg);
    }
}
