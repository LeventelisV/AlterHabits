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
    
    @NotNull
    @NotEmpty
    @Pattern(regexp="^[A-Za-z]*$",message = "Invalid Input For Name")
    @Size(min = 2, max = 45, message = "Name must be between 2 and 45 letters")
    private String name;
    @NotNull
    @NotEmpty
    @Size(min=2,max=45)
    private String surname;
    
    private String gender;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private String dateOfBirth;
    
    private String address;
    private int addressnumber;
    private String city;
    private String state;
    private String country;
    private int postalcode;
    private String email;
    private String phonenumber;
    private String mobilenumber;
    private String username;
    private String password;
    private String matchingpassword;

    public RegisterUserDto() {
    }

    public RegisterUserDto(String name, String surname, String gender, String dateOfBirth, String address, int addressnumber, String city, String state, String country, int postalcode, String email, String phonenumber, String mobilenumber, String username, String password, String matchingpassword) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.addressnumber = addressnumber;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalcode = postalcode;
        this.email = email;
        this.phonenumber = phonenumber;
        this.mobilenumber = mobilenumber;
        this.username = username;
        this.password = password;
        this.matchingpassword = matchingpassword;
    }

    public RegisterUserDto(String name, String surname, String gender, String dateOfBirth, String address, int addressnumber, String city, String state, String country, int postalcode, String email, String mobilenumber, String username, String password, String matchingpassword) {

        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.addressnumber = addressnumber;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalcode = postalcode;
        this.email = email;
        this.mobilenumber = mobilenumber;
        this.username = username;
        this.password = password;
        this.matchingpassword = matchingpassword;
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

    public String getAddress() {
        return address;
    }

    public int getAddressnumber() {
        return addressnumber;
    }

    public void setMatchingpassword(String matchingpassword) {
        this.matchingpassword = matchingpassword;
    }

    public String getMatchingpassword() {
        return matchingpassword;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public String getEmail() {
        return email;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getMobilenumber() {
        return mobilenumber;
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

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAddressnumber(int addressnumber) {
        this.addressnumber = addressnumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPostalcode(int postalcode) {
        this.postalcode = postalcode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
