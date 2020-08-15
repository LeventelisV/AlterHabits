/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.repositories.UserContactInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vaggelis
 */
@Service
public class UserContactInfoServiceImplementation implements UserContactInfoServiceInterface{
    
    @Autowired
    UserContactInfoRepository userContactInfoRepository;
    
    public boolean CheckIfEmailExists(String email){
    UserContactInfo user=userContactInfoRepository.findByEmail(email);
    if (user!=null)
        return true;
    else 
        return false;
    }

    @Override
    public void insertUserContactInfo(UserContactInfo userContactInfo) {
        userContactInfoRepository.save(userContactInfo);
    }
    
}
