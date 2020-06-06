package com.gogo.powerrangers.usecase.exception;

public class PowerRangerNotFoundException extends RuntimeException{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PowerRangerNotFoundException(String msg) {
        super(msg);
    }
}
