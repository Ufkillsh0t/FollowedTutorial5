package com.Ufkillsh0t.tutorial.exceptions;

public class InvalidNumberException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String msg;
	
	public InvalidNumberException(String msg){
		this.msg = msg;
	}
	
	public String getMessage(){
		return this.msg;
	}
}
