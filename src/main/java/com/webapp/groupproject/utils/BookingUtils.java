/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.utils;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.ReservationServiceInterface;
import com.webapp.groupproject.services.ShopSubscriptionAccessServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 *
 * @author vaggelis
 */

@Component
public   class BookingUtils {

    @Autowired
    MyUserServiceInterface myUserServiceInterface;
    
    @Autowired
    ReservationServiceInterface reservationServiceInterface;
    
    @Autowired
    ShopSubscriptionAccessServiceInterface shopSubscriptionAccessServiceInterface;

    public  MyUser takeTheLoggedInUser() {

        String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return myUserServiceInterface.findByUsername(loggedInUser);
    }

    public boolean checkIfAUserCanMakeAReservation(int userId, int shopId, int subscriprionId) {
        int numberOfPreviousReservatios = reservationServiceInterface.showReservationsOfAUserToAShop(userId, shopId);
        int maxDeservedVisits = shopSubscriptionAccessServiceInterface.findMaxDeservedVisits(subscriprionId, shopId);
        
        return (numberOfPreviousReservatios < maxDeservedVisits) ;
    }
}
