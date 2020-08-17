/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.RegisterUserDto;
//import com.webapp.groupproject.models.UserAdressInfo;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.models.UserPersonalInfo;
import com.webapp.groupproject.services.MyUserServiceInterface;
//import com.webapp.groupproject.services.UserAddressInfoServiceInterface;
import com.webapp.groupproject.services.UserContactInfoServiceInterface;
import com.webapp.groupproject.services.UserPersonalInfoServiceInterface;
import com.webapp.groupproject.utils.PersistenceUtils;
import com.webapp.groupproject.validators.RegisterUserValidator;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 *
 * @author vaggelis
 */
@Controller
public class RegisterUserController {

    @Autowired
    RegisterUserValidator registerUserValidator;

    @Autowired
    MyUserServiceInterface myUserServiceInterface;

    @Autowired
    UserContactInfoServiceInterface userContactServiseInterface;

//    @Autowired
//    UserAddressInfoServiceInterface userAddressInfoServiceInterface;
    @Autowired
    UserPersonalInfoServiceInterface userPersonalServiceInterface;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @InitBinder
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(registerUserValidator);
    }

    @GetMapping("preregisterform")
    public String showRegisterForm(ModelMap mm) {
        mm.addAttribute("registerUser", new RegisterUserDto());
        return "registerform";
    }

    @PostMapping("register")
    public String registerUserToDatabase(@Valid @ModelAttribute("registerUser") RegisterUserDto registerUserDto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {

            return "registerform";

        }
        registerUserDto.setPassword(passwordEncoder.encode(registerUserDto.getPassword()));
        MyUser myuser = PersistenceUtils.fillMyUserProperties(registerUserDto);
        myUserServiceInterface.insertMyUser(myuser);

        //take the userId from the database
        MyUser insertedUser = myUserServiceInterface.findByUsername(myuser.getUsername());

//        //insert the data at table UseraddressInfo
//            UserAdressInfo userAddressInfo = new UserAdressInfo();
//            userAddressInfo.setAdress(registerUserDto.getAddress());
//            userAddressInfo.setAdressNumber(Integer.parseInt(registerUserDto.getAddressNumber()));
//            userAddressInfo.setCity(registerUserDto.getCity());
//            userAddressInfo.setCountry(registerUserDto.getCountry());
//            userAddressInfo.setPostalCode(Integer.parseInt(registerUserDto.getPostalCode()));
//            userAddressInfo.setState(registerUserDto.getState());
//            userAddressInfo.setUserId(insertedUser);
//            userAddressInfoServiceInterface.insertUserAddressInfo(userAddressInfo);

        // insert data to user_contact_info_table
        UserContactInfo userContactInfo = PersistenceUtils.fillUserContactInfoProperties(registerUserDto, myuser);
        userContactServiseInterface.insertUserContactInfo(userContactInfo);

        //insert data to user_personal _info table
        UserPersonalInfo userPersonalInfo = PersistenceUtils.fillUserPersonalInfoProperties(registerUserDto, myuser);
        userPersonalServiceInterface.insertUserPersonalInfo(userPersonalInfo);
        return "demologin";

    }

}
