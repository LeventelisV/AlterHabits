/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.utils;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.Role;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.ReservationServiceInterface;

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
    
  

    public  MyUser takeTheLoggedInUser() {

        String loggedInUser = SecurityContextHolder.getContext().getAuthentication().getName();
        return myUserServiceInterface.findByUsername(loggedInUser);
    }

    public boolean checkIfAUserCanMakeAReservation(int userId,Role role) {
        int numberOfPreviousReservations = reservationServiceInterface.showNumberOfReservationsOfAUser(userId);
        int availableAppointments=role.getAvailableAppointments();

        
        return (numberOfPreviousReservations < availableAppointments ) ;
    }
    
    
    public int showNumberOfRemainingAppointments(int userId,Role role) {
        
        int numberOfPreviousReservations = reservationServiceInterface.showNumberOfReservationsOfAUser(userId);
        int availableAppointments=role.getAvailableAppointments();
        
        
        return ( availableAppointments-numberOfPreviousReservations  ) ;
    }
}
