/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Reservation;
import com.webapp.groupproject.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vaggelis
 */

@Service
public class ReservationServiceImplementation implements ReservationServiceInterface{

    
    @Autowired
    ReservationRepository reservationRepository;
    
    
    @Override
    public void insertReservation(Reservation reservation) {
       reservationRepository.save(reservation);
    }

    @Override
    public int showReservationsOfAUserToAShop(int userId, int ShopId) {
       return reservationRepository.showReservationsOfAUserToAShop(userId, ShopId);
    }
    
}
