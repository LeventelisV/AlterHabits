/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.ShopSubscriptionAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vaggelis
 */
 
public interface ShopSubscriptionAccessRepository extends JpaRepository<ShopSubscriptionAccess,Integer>{
    
   @Query(
    value="SELECT SA.ACCESS FROM shop_subscription_access sa where sa.subscription_id=?1 and sa.shop_id=?2",nativeQuery = true)
    public int findTheDeservedVisits(int subscriptionId,int shopid);
    
}
