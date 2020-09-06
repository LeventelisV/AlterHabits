/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.repositories.ShopSubscriptionAccessRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vaggelis
 */
@Service
public class ShopSubscriptionAccessServiceImplementation implements ShopSubscriptionAccessServiceInterface {
    
    
    @Autowired
    ShopSubscriptionAccessRepository s;
    
    @Override
    public int findMaxDeservedVisits(int subscriprionId,int shopId){
      return  s.findTheDeservedVisits(subscriprionId, shopId);
    }
}
