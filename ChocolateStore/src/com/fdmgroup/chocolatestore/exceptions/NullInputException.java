package com.fdmgroup.chocolatestore.exceptions;

public class NullInputException extends Exception{

	
	public NullInputException(String message){
		super(message);
	}
	
	public NullInputException(Throwable Cause){
		super(Cause);
	}
}
