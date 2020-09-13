/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.services.ActivityServiceInterface;
import com.webapp.groupproject.services.ShopServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vaggelis
 */
@RestController
public class BecomingPartnerController {
    
    @Autowired
    ActivityServiceInterface activityServiceInterface;
    
    @Autowired
    ShopServiceInterface shopServiceInterface;

    public String verifyFuturePartner(@RequestParam String shopName,
            @RequestParam String activity,
            @RequestParam String longitude,
            @RequestParam String shopPhoto,
            @RequestParam String latitude) {
        if((activityServiceInterface.findIfAnActivityExists(activity))&&(shopServiceInterface.findIfAShopNameDoesNotExists(shopName))){
          return "forward:insertPartner";  
        }
        else{
            return "invalid name for the application";
        }
    }

   
    @GetMapping("/insertPartner")
    public boolean show(){
        String shop="comrader";
        return shopServiceInterface.findIfAShopNameDoesNotExists(shop);
        
        
    }
    }
