/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.repositories;

import com.webapp.groupproject.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author vaggelis
 */
public interface ReservationRepository extends JpaRepository<Reservation,Integer>{
    
    @Query(
    value="Select count(*) from reservation r where r.user_id=?1 and r.shop_id=?2",nativeQuery=true)
    public int showReservationsOfAUserToAShop(int userId,int shopId);
    
}
