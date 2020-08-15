/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.UserPersonalInfo;
import com.webapp.groupproject.repositories.UserPersonalInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author vaggelis
 */
@Transactional
@Service
public class UserPersonalInfoServiceImplementation implements UserPersonalInfoServiceInterface {
    
   @Autowired
   UserPersonalInfoRepository userPersonalInfoRepository;
   
   public void insertUserPersonalInfo(UserPersonalInfo upi){
       userPersonalInfoRepository.save(upi);
   }

}
