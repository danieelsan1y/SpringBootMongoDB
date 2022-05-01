package com.danielsantana.springmongodb.services.exception;

public class ObjectNotFoungException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ObjectNotFoungException (String msg) {
		super(msg);
	}
	

}
