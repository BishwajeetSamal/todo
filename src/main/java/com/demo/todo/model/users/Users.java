package com.demo.todo.model.users;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Users {
    @Id
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(name = "user_generator", sequenceName = "user_sequence", initialValue = 1)
    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String userName;
    private String password;
    private String organisation;
    private String contactNo;
    private String dob;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOrganisation() {
        return organisation;
    }

    public void setOrganisation(String organisation) {
        this.organisation = organisation;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Users(long id, String firstName, String lastName, String emailId, String userName, String password,
            String organisation, String contactNo, String dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.userName = userName;
        this.password = password;
        this.organisation = organisation;
        this.contactNo = contactNo;
        this.dob = dob;
    }

    public Users() {
    }

    @Override
    public String toString() {
        return "Users [contactNo=" + contactNo + ", dob=" + dob + ", emailId=" + emailId + ", firstName=" + firstName
                + ", id=" + id + ", lastName=" + lastName + ", organisation=" + organisation + ", password=" + password
                + ", userName=" + userName + "]";
    }

}
