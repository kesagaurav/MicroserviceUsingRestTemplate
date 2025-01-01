package com.gaurav.exceptions;

public class ErrorMessage {

	private int error;
	private String message;
	public ErrorMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ErrorMessage(int error, String message) {
		super();
		this.error = error;
		this.message = message;
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "RunTimeExpection [error=" + error + ", message=" + message + "]";
	}
	
	
	
}
