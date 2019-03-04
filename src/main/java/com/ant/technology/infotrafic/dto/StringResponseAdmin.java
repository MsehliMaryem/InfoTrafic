package com.ant.technology.infotrafic.dto;

public class StringResponseAdmin  extends StringResponse{
	private String login;
	private String password;
	private String email;
	public StringResponseAdmin(boolean success, String message, String login, String password, String email) {
		super(success, message);
		this.login = login;
		this.password = password;
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	

}
