package com.ant.technology.infotrafic.dto;

public class StringResponseAbonnee  extends StringResponse{

	private String code;
	private String email;
	public StringResponseAbonnee(boolean success, String message, String code, String email) {
		super(success, message);
		this.code = code;
		this.email = email;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
