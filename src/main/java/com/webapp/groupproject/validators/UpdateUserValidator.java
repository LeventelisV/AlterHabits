/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.validators;

import com.webapp.groupproject.interfaces.UserDto;
import com.webapp.groupproject.models.UpdateUserDto;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.UserContactInfoServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author alexk
 */
@Component
public class UpdateUserValidator implements Validator {

//    @Autowired
//    MyUserServiceInterface myUserServiceInterface;
//
//    @Autowired
//    UserContactInfoServiceInterface userContactInfoServiceInterface;
    
    @Override
    public boolean supports(Class<?> type) {
        
        return UpdateUserDto.class.equals(type);
        
    }

    @Override
    public void validate(Object o, Errors errors) {
        
        UserDto updateUserDto = (UserDto) o;
        ValidatorMethods validatorMethods = new ValidatorMethods();
        validatorMethods.checkIfGenderIsChosen(updateUserDto, errors);
        boolean dateFormatValid = validatorMethods.checkIfDateOfBirthFormatIsValid(updateUserDto, errors);
        
        // filter for not running other validations if date format isn't valid
        if (dateFormatValid) {
            validatorMethods.checkIfUserAdult(updateUserDto, errors);
            validatorMethods.checkIfUserAlive(updateUserDto, errors);
        }
        validatorMethods.checkIfEmailUnique(updateUserDto, errors);
        validatorMethods.checkIfMobileNumberUnique(updateUserDto, errors);

    }
    
}
