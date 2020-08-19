/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.validators;

import com.webapp.groupproject.interfaces.UserDto;
import com.webapp.groupproject.models.RegisterUserDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author alexk
 */
@Component
public class RegisterUserValidator implements Validator {

   

    @Override
    public boolean supports(Class<?> type) {

        return RegisterUserDto.class.equals(type);

    }

    @Override
    public void validate(Object o, Errors errors) {
        
        UserDto registerUserDto = (UserDto) o;
        ValidatorMethods validatorMethods = new ValidatorMethods();
        validatorMethods.checkIfGenderIsChosen(registerUserDto, errors);
        boolean dateFormatValid = validatorMethods.checkIfDateOfBirthFormatIsValid(registerUserDto, errors);
        
        // filter for not running other validations if date format isn't valid
        if (dateFormatValid) {
            validatorMethods.checkIfUserAdult(registerUserDto, errors);
            validatorMethods.checkIfUserAlive(registerUserDto, errors);
        }
        validatorMethods.checkIfUsernameUnique(registerUserDto, errors);
        validatorMethods.checkIfPasswordsMatch(registerUserDto, errors);
        validatorMethods.checkIfEmailUnique(registerUserDto, errors);
        validatorMethods.checkIfUserInsertedPhoto(registerUserDto, errors);
        validatorMethods.checkIfUsersInsertedFileIsPhoto(registerUserDto, errors);
        validatorMethods.checkIfUsersPhotosSizeBiggerThanAllowed(registerUserDto, errors);
        validatorMethods.checkIfMobileNumberUnique(registerUserDto, errors);

    }

    

}
