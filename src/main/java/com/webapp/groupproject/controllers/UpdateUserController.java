/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.annotations.ImageFileConstraint;
import com.webapp.groupproject.interfaces.UserDto;
import com.webapp.groupproject.models.CreditDebitCard;
import com.webapp.groupproject.models.ImageDto;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.UpdateUserDto;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.models.UserPersonalInfo;
import com.webapp.groupproject.services.CreditDebitCardServiceInterface;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.UserContactInfoServiceInterface;
import com.webapp.groupproject.services.UserPersonalInfoServiceInterface;
import com.webapp.groupproject.utils.HelperMethods;
import com.webapp.groupproject.utils.PersistenceUtils;
import com.webapp.groupproject.validators.UpdateUserValidator;
import java.io.File;
import java.io.IOException;
import javax.validation.Valid;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexk
 */
@Controller
public class UpdateUserController {

    @Autowired
    UpdateUserValidator updateUserValidator;

    @Autowired
    MyUserServiceInterface myUserServiceInterface;

    @Autowired
    UserPersonalInfoServiceInterface userPersonalInfoServiceInterface;

    @Autowired
    UserContactInfoServiceInterface userContactInfoServiceInterface;

    @Autowired
    CreditDebitCardServiceInterface creditDebitCardServiceInterface;

    @InitBinder("userUpdates")
    private void initBinder(WebDataBinder binder) {
        binder.addValidators(updateUserValidator);
    }

    @GetMapping("updateinfo")
    public String showUpdateInfoForm(ModelMap mm) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsersUsername = authentication.getName();
        UpdateUserDto currentUsersInfoToUpdate = new UpdateUserDto();
        if (currentUsersUsername != null) {
            MyUser currentUser = myUserServiceInterface.findByUsername(currentUsersUsername);
            UserPersonalInfo currentUsersPersonalInfo = userPersonalInfoServiceInterface.findUserPersonalInfoByUserId(currentUser);
            PersistenceUtils.fillUsersPersonalInfoToUpdate(currentUsersInfoToUpdate, currentUsersPersonalInfo, currentUser.getUserId());
            UserContactInfo currentUsersContactInfo = userContactInfoServiceInterface.findUserContactInfoByUserId(currentUser);
            PersistenceUtils.fillUsersContactInfoToUpdate(currentUsersInfoToUpdate, currentUsersContactInfo);
            mm.addAttribute("updateUser", currentUsersInfoToUpdate);
        }

        return "updateinfo";
    }

    @PostMapping("update")
    public String updateUsersInfo(@Valid @ModelAttribute("updateUser") UpdateUserDto userUpdates,
            BindingResult br) {
        if (br.hasErrors()) {
            return "updateinfo";
        }
        MyUser userUpdated = myUserServiceInterface.findById(userUpdates.getUserId());
        UserPersonalInfo userPersonalInfoUpdated = userPersonalInfoServiceInterface.findUserPersonalInfoByUserId(userUpdated);
        PersistenceUtils.updateUsersPersonalInfo(userUpdates, userPersonalInfoUpdated);
        userPersonalInfoServiceInterface.saveUserPersonalInfo(userPersonalInfoUpdated);
        UserContactInfo userContactInfoUpdated = userContactInfoServiceInterface.findUserContactInfoByUserId(userUpdated);
        PersistenceUtils.updateUsersContactInfo(userUpdates, userContactInfoUpdated);
        userContactInfoServiceInterface.saveUserContactInfo(userContactInfoUpdated);

        return "home";
    }

    @GetMapping("changephoto")
    public String showUpdatePhoto(ModelMap mm){
        mm.addAttribute("newPhoto",new ImageDto());
        return "updatephoto";
    }
     
    @PostMapping("updatephoto")
    public String updateUsersPhoto(@Valid @ModelAttribute("newPhoto") ImageDto usersImageDto,
            BindingResult result) throws IOException {
        if(result.hasErrors()){
            return "updatephoto";
        }
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsersUsername = authentication.getName();
        MyUser currentUser = myUserServiceInterface.findByUsername(currentUsersUsername);
        File oldPhoto = new File("E:\\Downloads\\UsersPhotos\\" + currentUser.getUserId() + ".jpg");
        oldPhoto.delete();
        usersImageDto.getUserPhoto().transferTo(new File("E:\\Downloads\\UsersPhotos\\" + currentUser.getUserId() + ".jpg"));
        return "redirect:photo";
    }
}
