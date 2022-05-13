package com.demo.todo.dto;

public class LoginDto {

	private String userName;
	private String userPassword;

	public LoginDto(String userName, String userPassword) {
		this.userName = userName;
		this.userPassword = userPassword;
	}

	public LoginDto() {
	}

	public String getuserName() {
		return userName;
	}

	public void setuserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String toString() {
		return "LoginDto [userName=" + userName + ", userPassword=" + userPassword + "]";
	}

}
