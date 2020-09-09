/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.validators;

import com.webapp.groupproject.SpringContext;
import com.webapp.groupproject.interfaces.UserDto;
import com.webapp.groupproject.models.CreditDebitCard;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.RegisterUserDto;
import com.webapp.groupproject.models.UpdateUserDto;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.services.CreditDebitCardServiceInterface;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.UserContactInfoServiceInterface;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

/**
 *
 * @author alexk
 */
public class ValidatorMethods {

    public ValidatorMethods() {
    }

    private MyUserServiceInterface getMyUserService() {
        return SpringContext.getBean(MyUserServiceInterface.class);
    }

    private UserContactInfoServiceInterface getUserContactInfoService() {
        return SpringContext.getBean(UserContactInfoServiceInterface.class);
    }
    
    private CreditDebitCardServiceInterface getCardServiceInterface() {
        return SpringContext.getBean(CreditDebitCardServiceInterface.class);
    }

    // check if user chose gender
    void checkIfGenderIsChosen(UserDto userDto, Errors errors) {
        if (userDto instanceof RegisterUserDto) {
            RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
            if (registerUserDto.getGender().equals("NONE")) {
                errors.rejectValue("gender", "gender.not.selected");
            }
        }
        if (userDto instanceof UpdateUserDto) {
            UpdateUserDto updateUserDto = (UpdateUserDto) userDto;
            if (updateUserDto.getGender().equals("NONE")) {
                errors.rejectValue("gender", "gender.not.selected");
            }
        }
    }

    // check if user's date of birth format is ok
    boolean checkIfDateOfBirthFormatIsValid(UserDto userDto, Errors errors) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        if (userDto instanceof RegisterUserDto) {
            RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
            try {
                sdf.parse(registerUserDto.getDateOfBirth());
                return true;
            } catch (ParseException e) {
                errors.rejectValue("dateOfBirth", "date.wrong");
                return false;
            }
        }
        if (userDto instanceof UpdateUserDto) {
            UpdateUserDto updateUserDto = (UpdateUserDto) userDto;
            try {
                sdf.parse(updateUserDto.getDateOfBirth());
                return true;
            } catch (ParseException e) {
                errors.rejectValue("dateOfBirth", "date.wrong");
                return false;
            }
        }
        return false;
    }

    // check if user is adult (user's age>=18)
    void checkIfUserAdult(UserDto userDto, Errors errors) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (userDto instanceof RegisterUserDto) {
            RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
            try {
                Period period = Period.between(LocalDate.parse(registerUserDto.getDateOfBirth(), dtf), LocalDate.now());
                if (period.getYears() < 18) {
                    errors.rejectValue("dateOfBirth", "date.under");
                }
            } catch (DateTimeParseException e) {
                errors.rejectValue("dateOfBirth", "date.wrong");
            }
        }
        if (userDto instanceof UpdateUserDto) {
            UpdateUserDto updateUserDto = (UpdateUserDto) userDto;
            try {
                Period period = Period.between(LocalDate.parse(updateUserDto.getDateOfBirth(), dtf), LocalDate.now());
                if (period.getYears() < 18) {
                    errors.rejectValue("dateOfBirth", "date.under");
                }
            } catch (DateTimeParseException e) {
                errors.rejectValue("dateOfBirth", "date.wrong");
            }
        }

    }

    // check if date given is extremely big
    void checkIfUserAlive(UserDto userDto, Errors errors) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        if (userDto instanceof RegisterUserDto) {
            RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
            try {
                Period period = Period.between(LocalDate.parse(registerUserDto.getDateOfBirth(), dtf), LocalDate.now());
                if (period.getYears() > 100) {
                    errors.rejectValue("dateOfBirth", "date.over");
                }
            } catch (DateTimeParseException e) {
                errors.rejectValue("dateOfBirth", "date.wrong");
            }
        }
        if (userDto instanceof UpdateUserDto) {
            UpdateUserDto updateUserDto = (UpdateUserDto) userDto;
            try {
                Period period = Period.between(LocalDate.parse(updateUserDto.getDateOfBirth(), dtf), LocalDate.now());
                if (period.getYears() > 100) {
                    errors.rejectValue("dateOfBirth", "date.over");
                }
            } catch (DateTimeParseException e) {
                errors.rejectValue("dateOfBirth", "date.wrong");
            }
        }
    }

    // check if username is unique in database
    void checkIfUsernameUnique(UserDto userDto, Errors errors) {
        if (userDto instanceof RegisterUserDto) {
            RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
            if (getMyUserService().findByUsername(registerUserDto.getUsername()) != null) {
                errors.rejectValue("username", "username.not.unique");
            }
        }
    }

    // check if passwords given match
    void checkIfPasswordsMatch(UserDto userDto, Errors errors) {
        if (userDto instanceof RegisterUserDto) {
            RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
            if (!registerUserDto.getPassword().equals(registerUserDto.getMatchingPassword())) {
                errors.rejectValue("matchingPassword", "passwords.not.matching");
            }
        }
    }

    // check if email already exists in database
    void checkIfEmailUnique(UserDto userDto, Errors errors) {
        if (userDto instanceof RegisterUserDto) {
            RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
            if (getUserContactInfoService().checkIfEmailExists(registerUserDto.getEmail())) {
                errors.rejectValue("email", "email.not.unique");
            }
        }
        if (userDto instanceof UpdateUserDto) {
            UpdateUserDto updateUserDto = (UpdateUserDto) userDto;
            if (getUserContactInfoService().checkIfEmailExists(updateUserDto.getEmail())) {
                if(!checkIfUsedEmailBelongsToCurrentUser(updateUserDto)){
                errors.rejectValue("email", "email.not.unique");
                }
            }
        }
    }
    
    void checkIfMobileNumberUnique(UserDto userDto, Errors errors) {
        if (userDto instanceof RegisterUserDto) {
            RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
            if (getUserContactInfoService().checkIfMobileNumberExists(registerUserDto.getMobileNumber())) {
                errors.rejectValue("mobileNumber", "mobile.number.not.unique");
            }
        }
        if (userDto instanceof UpdateUserDto) {
            UpdateUserDto updateUserDto = (UpdateUserDto) userDto;
            if (getUserContactInfoService().checkIfMobileNumberExists(updateUserDto.getMobileNumber())) {
                if(!checkIfUsedPhoneNumberBelongsToCurrentUser(updateUserDto)){
                errors.rejectValue("mobileNumber", "mobile.number.not.unique");
                }
            }
        }
    }

    /*
    check if new email on update is the same with the old one,
     and if so let it be,
    if it isn't, reject value because already exists for another users contact info
     */
    private boolean checkIfUsedEmailBelongsToCurrentUser(UpdateUserDto updateUserDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsersUsername = authentication.getName();
        MyUser currentUser = getMyUserService().findByUsername(currentUsersUsername);
        UserContactInfo userContactInfo = getUserContactInfoService().findUserContactInfoByEmail(updateUserDto.getEmail());
        MyUser userWhomEmailBelongsTo = getMyUserService().findById(userContactInfo.getUserId().getUserId());
        
        if(currentUser.getUserId().intValue() == userWhomEmailBelongsTo.getUserId().intValue()) {
            return true;
        }
        return false;
    }
    
    /*
    check if new mobile number on update is the same with the old one,
     and if so let it be,
    if it isn't, reject value because already exists for another users contact info
     */
    private boolean checkIfUsedPhoneNumberBelongsToCurrentUser(UpdateUserDto updateUserDto) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsersUsername = authentication.getName();
        MyUser currentUser = getMyUserService().findByUsername(currentUsersUsername);
        UserContactInfo userContactInfo = getUserContactInfoService().findUserContactInfoByMobileNumber(updateUserDto.getMobileNumber());
        MyUser userWhomMobileNumberBelongsTo = getMyUserService().findById(userContactInfo.getUserId().getUserId());
        
        if(currentUser.getUserId().intValue() == userWhomMobileNumberBelongsTo.getUserId().intValue()) {
            return true;
        }
        return false;
    }
    
    void checkIfCreditDebitCardCredentialsValid(UserDto userDto, Errors errors) {
        RegisterUserDto registerUserDto = (RegisterUserDto) userDto;
        CreditDebitCard registeredCard = getCardServiceInterface().findByCreditDebitCardNumber(registerUserDto.getCreditDebitCardNumber());
        if(registeredCard.getCreditDebitCardName().equals(registerUserDto.getCreditDebitCardName())
                && registeredCard.getCreditDebitCardExpirationYear() == Integer.parseInt(registerUserDto.getCreditDebitCardExpYear())
                && registeredCard.getCreditDebitCardExpirationMonth() == Integer.parseInt(registerUserDto.getCreditDebitCardExpMonth())) {
            
        }else{
            errors.rejectValue("creditDebitCardNumber", "card.wrong.credentials");
        }
    }
}
