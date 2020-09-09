/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.repositories.MyUserRepository;
import com.webapp.groupproject.repositories.ShopsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author alexk
 */
@RestController
@RequestMapping("/api/test")
public class TestController {
    
    @Autowired
    MyUserRepository mur;

    @Autowired
    ShopsRepository sr;
    
    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER')")
    public String userAccess() {
        return "User Content.";
    }
    
    @GetMapping("/premium")
    @PreAuthorize("hasRole('USER') or hasRole('PREMIUM')")
    public String premiumAccess() {
        return "Premium Content.";
    }
    
    @GetMapping("/admin")
    @PreAuthorize("hasRole('USER') or hasRole('PREMIUM') or hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Content.";
    }
    
//    @GetMapping("/getusers")
//    public List<MyUser> returnUsers(){
//        return mur.findAll();
//    }
//    
//    @GetMapping("/getshops")
//    public List<Shop> returnShops(){
//        return sr.findAll();
//    }
}
