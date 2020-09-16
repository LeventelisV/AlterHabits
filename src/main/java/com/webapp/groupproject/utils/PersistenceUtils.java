/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.utils;

import com.webapp.groupproject.models.CreditDebitCard;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.RegisterUserDto;
import com.webapp.groupproject.models.UpdateUserDto;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.models.UserPersonalInfo;

/**
 *
 * @author alexk
 */
public class PersistenceUtils {

    public static MyUser fillMyUserProperties(RegisterUserDto registerUserDto) {

        MyUser newMyUser = new MyUser();
        newMyUser.setUserPassword(registerUserDto.getPassword());
        newMyUser.setUsername(registerUserDto.getUsername());
        return newMyUser;

    }

    public static UserContactInfo fillUserContactInfoProperties(RegisterUserDto registerUserDto, MyUser myUserInserted) {

        UserContactInfo newUserContactInfo = new UserContactInfo();
        newUserContactInfo.setEmail(registerUserDto.getEmail());
        newUserContactInfo.setMobileNumber(registerUserDto.getMobileNumber());
        newUserContactInfo.setPhoneNumber(registerUserDto.getPhoneNumber());
        newUserContactInfo.setUserId(myUserInserted);
        return newUserContactInfo;

    }

    public static UserPersonalInfo fillUserPersonalInfoProperties(RegisterUserDto registerUserDto, MyUser myUserInserted) {

        UserPersonalInfo newUserPersonalInfo = new UserPersonalInfo();
        newUserPersonalInfo.setFirstName(registerUserDto.getName());
        newUserPersonalInfo.setDateOfBirth(HelperMethods.parseStringToDate(registerUserDto.getDateOfBirth()));
        newUserPersonalInfo.setLastName(registerUserDto.getSurname());
        newUserPersonalInfo.setGender(registerUserDto.getGender());
        newUserPersonalInfo.setUserId(myUserInserted);
        return newUserPersonalInfo;

    }

    public static CreditDebitCard fillCreditDebitCardInfo(RegisterUserDto registerUserDto) {

        CreditDebitCard newCreditDebitCard = new CreditDebitCard();
        newCreditDebitCard.setCreditDebitCardNumber(registerUserDto.getCreditDebitCardNumber());
        newCreditDebitCard.setCreditDebitCardName(registerUserDto.getCreditDebitCardName());
        newCreditDebitCard.setCreditDebitCardExpirationMonth(Integer.parseInt(registerUserDto.getCreditDebitCardExpMonth()));
        newCreditDebitCard.setCreditDebitCardExpirationYear(Integer.parseInt(registerUserDto.getCreditDebitCardExpYear()));
        return newCreditDebitCard;

    }

    public static void fillUsersPersonalInfoToUpdate(UpdateUserDto usersInfoToUpdate, UserPersonalInfo usersPersonalInfo, Integer userId) {

        usersInfoToUpdate.setUserId(userId);
        usersInfoToUpdate.setName(usersPersonalInfo.getFirstName());
        usersInfoToUpdate.setSurname(usersPersonalInfo.getLastName());
        usersInfoToUpdate.setDateOfBirth(usersPersonalInfo.getDateOfBirth().toString());
        usersInfoToUpdate.setGender(usersPersonalInfo.getGender());

    }

    public static void fillUsersContactInfoToUpdate(UpdateUserDto usersInfoToUpdate, UserContactInfo usersPersonalInfo) {

        usersInfoToUpdate.setEmail(usersPersonalInfo.getEmail());
        usersInfoToUpdate.setPhoneNumber(usersPersonalInfo.getPhoneNumber());
        usersInfoToUpdate.setMobileNumber(usersPersonalInfo.getMobileNumber());

    }

    public static void updateUsersPersonalInfo(UpdateUserDto userUpdates, UserPersonalInfo usersOldPersonalInfo) {

        usersOldPersonalInfo.setFirstName(userUpdates.getName());
        usersOldPersonalInfo.setLastName(userUpdates.getSurname());
        usersOldPersonalInfo.setGender(userUpdates.getGender());
        usersOldPersonalInfo.setDateOfBirth(HelperMethods.parseStringToDate(userUpdates.getDateOfBirth()));

    }

    public static void updateUsersContactInfo(UpdateUserDto userUpdates, UserContactInfo usersOldContactInfo) {

        userUpdates.setEmail(userUpdates.getEmail());
        userUpdates.setPhoneNumber(userUpdates.getPhoneNumber());
        userUpdates.setMobileNumber(userUpdates.getMobileNumber());

    }
}
