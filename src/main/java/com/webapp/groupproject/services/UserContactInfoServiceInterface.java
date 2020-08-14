/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.UserContactInfo;

/**
 *
 * @author vaggelis
 */
public interface UserContactInfoServiceInterface {
    
    public boolean CheckIfEmailExists(String email);
    
    public void insertUserContactInfo(UserContactInfo userContactInfo);
}
