package com.fdmgroup.chocolatestore.exceptions;

public class StorableNotFoundException extends Exception{
	
	public StorableNotFoundException(String message){
		super(message);
	}
	
	public StorableNotFoundException(Throwable Cause){
		super(Cause);
	}

}
