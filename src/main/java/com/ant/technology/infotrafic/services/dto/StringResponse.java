package com.ant.technology.infotrafic.services.dto;

import java.io.Serializable;

public class StringResponse implements Serializable {

	private boolean success;
	private String message;
	
	
	
	
	public StringResponse(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
