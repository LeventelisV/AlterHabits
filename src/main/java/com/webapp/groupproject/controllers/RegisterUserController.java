/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.helperMethods.HelperMethods;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.RegisterUserDto;
import com.webapp.groupproject.models.UserAdressInfo;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.models.UserPersonalInfo;
import com.webapp.groupproject.repositories.MyUserRepository;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.UserAddressInfoServiceInterface;
import com.webapp.groupproject.services.UserContactInfoServiceInterface;
import com.webapp.groupproject.services.UserPersonalInfoServiceInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author vaggelis
 */
@Controller
public class RegisterUserController {

//    @Autowired
//    MyUserRepository myUserRepository;
    @Autowired
    MyUserServiceInterface myUserServiceInterface;

    @Autowired
    UserContactInfoServiceInterface userContactServiseInterface;

    @Autowired
    UserAddressInfoServiceInterface userAddressInfoServiceInterface;

    @Autowired
    UserPersonalInfoServiceInterface userPersonalServiceInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/preregisterform")
    public String showRegisterForm(ModelMap mm) {
        mm.addAttribute("registerUser", new RegisterUserDto());
        return "registerform";
    }
    
    //if the username of the registration already exists or the email of the registration already exists
    //or the two passwords are different
    @GetMapping("/registerAgain")
    public String showRegisterFormAgain(ModelMap mm) {
        mm.addAttribute("registerUser", new RegisterUserDto());
        return "registerform";
    }

    @PostMapping("/register")
    public String checkIfUserExists(@Valid @ModelAttribute("registerUser") RegisterUserDto registerUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            registerUserDto.setPassword("PASSWORD");
            registerUserDto.setMatchingpassword("*");
            return "registerform";

        } else if (registerUserDto.getPassword().equals(registerUserDto.getMatchingpassword())
                && (myUserServiceInterface.findByUsername(registerUserDto.getUsername()) == null)
                && (!userContactServiseInterface.CheckIfEmailExists(registerUserDto.getEmail()))) {
            registerUserDto.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
            registerUserDto.setMatchingpassword(passwordEncoder.encode(registerUserDto.getMatchingpassword()));
            MyUser myuser = new MyUser();
            myuser.setUserPassword(registerUserDto.getPassword());
            myuser.setUsername(registerUserDto.getUsername());
            myUserServiceInterface.insertMyUser(myuser);
//        //take the userId from the database
            MyUser insertedUser = myUserServiceInterface.findByUsername(myuser.getUsername());
//
//        //insert the data at table UseraddressInfo
            UserAdressInfo userAddressInfo = new UserAdressInfo();
            userAddressInfo.setAdress(registerUserDto.getAddress());
            userAddressInfo.setAdressNumber(registerUserDto.getAddressnumber());
            userAddressInfo.setCity(registerUserDto.getCity());
            userAddressInfo.setCountry(registerUserDto.getCountry());
            userAddressInfo.setPostalCode(registerUserDto.getPostalcode());
            userAddressInfo.setState(registerUserDto.getState());
            userAddressInfo.setUserId(insertedUser);
            userAddressInfoServiceInterface.insertUserAddressInfo(userAddressInfo);
////  insert data to user_contact_info_table
            UserContactInfo userContactInfo = new UserContactInfo();
            userContactInfo.setEmail(registerUserDto.getEmail());
            userContactInfo.setMobileNumber(registerUserDto.getMobilenumber());
            userContactInfo.setPhoneNumber(registerUserDto.getPhonenumber());
            userContactInfo.setUserId(insertedUser);
            userContactServiseInterface.insertUserContactInfo(userContactInfo);

//        //insert data to user_personal _info table
            UserPersonalInfo userPersonalInfo = new UserPersonalInfo();
            userPersonalInfo.setFirstName(registerUserDto.getName());
            try {
                userPersonalInfo.setDateOfBirth(HelperMethods.parseStringToDate(registerUserDto.getDateOfBirth()));
            } catch (ParseException ex) {
                ex.printStackTrace();
            }
            userPersonalInfo.setLastName(registerUserDto.getSurname());
            userPersonalInfo.setGender(registerUserDto.getGender());
            userPersonalInfo.setUserId(insertedUser);
            userPersonalServiceInterface.insertUserPersonalInfo(userPersonalInfo);
            return "demologin";

        } else {
            return "redirect:registerAgain";
        }

    }
}
