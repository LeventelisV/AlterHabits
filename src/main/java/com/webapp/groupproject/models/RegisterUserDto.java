/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

/**
 *
 * @author vaggelis
 */
import java.time.LocalDate;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author vaggelis
 */
public class RegisterUserDto {
// TODO ANNOTATIONS FOR VALIDATE

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

//    @NotEmpty(message = "Address is mandatory!")
//    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid input for address. Address must contain only letters!")
//    @Size(min = 1, max = 100, message = "Address can have 100 characters max!")
//    private String address;
//    
//    @NotEmpty(message = "Address number is mandatory!")
//    @Pattern(regexp = "[0-9]+", message = "Only numbers allowed on this field!")
//    @Size(min = 1, max = 1000, message = "Only address numbers eligible are between 1 and 1000!")
//    private String addressNumber;
//    
//    @NotEmpty(message = "City is mandatory!")
//    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid input for city. City must contain only letters!")
//    @Size(min = 1, max = 80, message = "Address can have 80 characters max!")
//    private String city;
//    @NotEmpty(message = "State is mandatory!")
//    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid input for state. State must contain only letters!")
//    @Size(min = 1, max = 80, message = "State can have 80 characters max!")
//    private String state;
//    @NotEmpty(message = "Country is mandatory!")
//    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid input for country. Country must contain only letters!")
//    @Size(min = 1, max = 80, message = "Country can have 80 characters max!")
//    private String country;
//    @NotEmpty(message = "Postal code is mandatory!")
//    @Pattern(regexp = "[0-9]+", message = "Only numbers allowed on this field!")
//    @Size(min = 10000, max = 99999, message = "Postal code must consist of 5 numbers!")
//    private String postalCode;
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

    @NotEmpty(message = "Username is mandatory!")
    @Size(min = 6, max = 20, message = "Username must be between 6 and 20 characters!")
    private String username;

    @NotEmpty(message = "Password is mandatory!")
    @Pattern(regexp = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$", message = "Password must be at least 8 characters "
            + "and have at least one upper case letter (A-Z), one lower case letter (a-z), one digit (0-9) and one special character (#?!@$%^&*-)!")
    private String password;

    @NotEmpty(message = "This field is mandatory!")
    private String matchingPassword;

    public RegisterUserDto() {
    }

//    public RegisterUserDto(String name, String surname, String gender, String dateOfBirth, String address, String addressNumber, String city, String state, String country, String postalCode, String email, String phoneNumber, String mobileNumber, String username, String password, String matchingPassword) {
//        this.name = name;
//        this.surname = surname;
//        this.gender = gender;
//        this.dateOfBirth = dateOfBirth;
//        this.address = address;
//        this.addressNumber = addressNumber;
//        this.city = city;
//        this.state = state;
//        this.country = country;
//        this.postalCode = postalCode;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.mobileNumber = mobileNumber;
//        this.username = username;
//        this.password = password;
//        this.matchingPassword = matchingPassword;
//    }
    public RegisterUserDto(String name, String surname, String gender, String dateOfBirth, String email, String phoneNumber, String mobileNumber, String username, String password, String matchingPassword) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.mobileNumber = mobileNumber;
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

//    public RegisterUserDto(String name, String surname, String gender, String dateOfBirth, String address, String addressNumber, String city, String state, String country, String postalCode, String email, String phoneNumber, String mobileNumber, String username, String password, String matchingPassword) {
//        this.name = name;
//        this.surname = surname;
//        this.gender = gender;
//        this.dateOfBirth = dateOfBirth;
//        this.address = address;
//        this.addressNumber = addressNumber;
//        this.city = city;
//        this.state = state;
//        this.country = country;
//        this.postalCode = postalCode;
//        this.email = email;
//        this.phoneNumber = phoneNumber;
//        this.mobileNumber = mobileNumber;
//        this.username = username;
//        this.password = password;
//        this.matchingPassword = matchingPassword;
//    }
    public RegisterUserDto(String name, String surname, String gender, String dateOfBirth, String email, String mobileNumber, String username, String password, String matchingPassword) {

        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.username = username;
        this.password = password;
        this.matchingPassword = matchingPassword;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

//    public String getAddress() {
//        return address;
//    }
//
//    public String getAddressNumber() {
//        return addressNumber;
//    }
    public void setMatchingPassword(String matchingPassword) {
        this.matchingPassword = matchingPassword;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

//    public String getCity() {
//        return city;
//    }
//
//    public String getState() {
//        return state;
//    }
//
//    public String getCountry() {
//        return country;
//    }
//
//    public String getPostalCode() {
//        return postalCode;
//    }
    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public void setAddress(String address) {
//        this.address = address;
//    }
//
//    public void setAddressNumber(String addressNumber) {
//        this.addressNumber = addressNumber;
//    }
//
//    public void setCity(String city) {
//        this.city = city;
//    }
//
//    public void setState(String state) {
//        this.state = state;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }
//
//    public void setPostalCode(String postalCode) {
//        this.postalCode = postalCode;
//    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
