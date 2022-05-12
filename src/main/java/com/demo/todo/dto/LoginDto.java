package com.demo.todo.dto;

public class LoginDto {
    private String UserName;
    private String emailId;
    private String userPassword;

    public LoginDto(String userName, String emailId, String userPassword) {
        UserName = userName;
        this.emailId = emailId;
        this.userPassword = userPassword;
    }

    public LoginDto() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "LoginDto [UserName=" + UserName + ", emailId=" + emailId + ", userPassword=" + userPassword + "]";
    }

}
