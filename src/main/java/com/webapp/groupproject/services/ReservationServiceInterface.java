/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import com.webapp.groupproject.models.Reservation;

/**
 *
 * @author vaggelis
 */
public interface ReservationServiceInterface {
    
    
    public void insertReservation(Reservation reservation);
    
    
    public int showReservationsOfAUserToAShop(int userId,int ShopId);
}
