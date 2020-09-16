/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.pojo.Activity;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.utils.QuizFilters;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.List;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexk
 */
@RestController
public class HomeController {

    @Autowired
    MyUserServiceInterface myUserServiceInterface;
    
    @GetMapping("/quiz/answers")
    public String showQuizAnswers(
            @RequestParam String answer1,
            @RequestParam String answer2,
            @RequestParam String answer3,
            @RequestParam String answer4
    ) throws MalformedURLException, IOException {
        ObjectMapper om = new ObjectMapper();
        List<Activity> activities = om.readValue(new File("src/main/resources/activities.json"), new TypeReference<List<Activity>>() {
        });
        List<Activity> filteredActivities = QuizFilters.filterActivitiesBasedOnAnswers(answer1, answer2, answer3, answer4, activities);
        if (filteredActivities.isEmpty()) {
            return null;
        } else {
            return om.writeValueAsString(filteredActivities);
        }

    }

    @GetMapping(value = "profilephoto", produces = MediaType.IMAGE_JPEG_VALUE)
    @ResponseBody
    public byte[] showProfilePhotograph() throws IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentUsersUsername = authentication.getName();
        MyUser currentUser = myUserServiceInterface.findByUsername(currentUsersUsername);
        InputStream in = getClass()
                .getResourceAsStream("E:\\Downloads\\UsersPhotos\\"+currentUser.getUserId()+".jpg");
        InputStream inn = new FileInputStream(new File("E:\\Downloads\\UsersPhotos\\9.jpg"));
        return IOUtils.toByteArray(inn);
    }
    
    @RequestMapping(value = "photo", method = { RequestMethod.GET, RequestMethod.POST })
    public String showPhoto(){
        return "profilephoto";
    }
    
    @GetMapping("preregisterform")
    public String showRegisterForm() {
        return "registerform";
    }
    
    @GetMapping("lalaform")
    public String showLala(){
        return "lalaform";
    }
}
