/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.Activity;
import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.models.ShopDto;

import com.webapp.groupproject.services.ActivityServiceInterface;
import com.webapp.groupproject.services.ShopServiceInterface;

import com.webapp.groupproject.utils.PersistenceUtils;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vaggelis
 */
@RestController
public class ShowAvailableShopsController {

    @Autowired
    ShopServiceInterface shopServiceInterface;

    @Autowired
    ActivityServiceInterface activityServiceInterface;
    
  

    @GetMapping("/shops") 
    public List<ShopDto> showAllShops() {
        List<Shop> shops = new ArrayList();
        shops.addAll(shopServiceInterface.findShops());
     //   DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
    //   MyUser u= (MyUser) auth.getUserCache();
        return PersistenceUtils.fillShopDto(shops);

    }

    @GetMapping("/shops/{id}")
    public List<ShopDto> showAllShopsForASpecificActivity(@PathVariable int id) {
        List<Shop> shops = new ArrayList();
        Activity a=activityServiceInterface.findActivityById(id);
        shops.addAll(a.getShops());
        return PersistenceUtils.fillShopDto(shops);
    }
    

}                
