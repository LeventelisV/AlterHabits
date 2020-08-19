/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import com.webapp.groupproject.interfaces.UserDto;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author alexk
 */
public class UpdateUserDto implements UserDto{
    
    private Integer userId;
    
    @NotEmpty(message = "Name can't be empty!")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid input for name. Name must contain only letters!")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 45 letters!")
    private String name;

    @NotEmpty(message = "Surname can't be empty!")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Invalid input for surname. Surname must contain only letters!")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 45 letters")
    private String surname;
    private String gender;
    private String dateOfBirth;
    
    @Email(message = "Must be a well-formed email address!")
    @NotEmpty(message = "Email is mandatory!")
    @Size(min = 1, max = 200, message = "Email can't be more than 200 characters!")
    private String email;

    @Pattern(regexp = "^21[0-9]+$", message = "Only numbers allowed on this field!")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits!")
    private String phoneNumber;

    @NotEmpty(message = "Mobile number is mandatory!")
    @Pattern(regexp = "^69[0-9]+$", message = "Only numbers allowed on this field!")
    @Size(min = 10, max = 10, message = "Phone number must be 10 digits!")
    private String mobileNumber;

    public UpdateUserDto() {
    }

    public UpdateUserDto(Integer userId, String name, String surname, String gender, String dateOfBirth, String email, String phoneNumber, String mobileNumber) {
        this.userId = userId;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    
}
