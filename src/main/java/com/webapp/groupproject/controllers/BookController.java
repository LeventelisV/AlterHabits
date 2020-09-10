/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.Activity;
import com.webapp.groupproject.models.BookingDto;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.RegisterUserDto;
import com.webapp.groupproject.models.Reservation;
import com.webapp.groupproject.models.Role;
import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.services.ActivityServiceInterface;
import com.webapp.groupproject.services.MyUserServiceInterface;
import com.webapp.groupproject.services.ReservationServiceInterface;
import com.webapp.groupproject.services.RoleServiceInterface;
import com.webapp.groupproject.services.ShopServiceInterface;
import com.webapp.groupproject.utils.BookingUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vaggelis
 */
@RestController
public class BookController {

    @Autowired
    ShopServiceInterface shopServiceInterface;

    @Autowired
    MyUserServiceInterface myUserServiceInterface;

    @Autowired
    ReservationServiceInterface reservationServiceInterface;

    @Autowired
    ActivityServiceInterface activityServiceInterface;

    @Autowired
    RoleServiceInterface roleServiceInterface;

    @Autowired
    BookingUtils bookingUtils;

//    @GetMapping("/book")
//    public String bookAppointment(@RequestBody BookingDto bookingDto) {
//        MyUser myUser = bookingUtils.takeTheLoggedInUser();
//        if (myUser.getUsername().equals(bookingDto.getUsername())) {
//            Role userRole = myUser.getRoleId();
//          if(bookingUtils.checkIfAUserCanMakeAReservation(myUser.getUserId(), userRole)){
//              Reservation reservation=new Reservation(
//                      null,
//                      bookingDto.getReservationDate(),
//                      shopServiceInterface.findByShopId(Integer.parseInt(bookingDto.getShopId())),
//                      myUser.getUserId()
//                      
//                      );
//                      
//              reservationServiceInterface.insertReservation(new Reservation(,,myUser));
//          }
//              
//          }
//        }
//    }








//       
//        int userId=myUser.getUserId();
//        String message="";
//        int subscriptionId=1;    //8a to svhsw otan er8ei to id apo ton client   
//        int shopId = 3;//8a to svhsw otan er8ei to id apo ton client
//        int activityId = 3;//8a to svhsw otan er8ei to id apo ton client
   //      if(bookingUtils.checkIfAUserCanMakeAReservation(userId, shopId, subscriptionId)){
//        Shop shop = shopServiceInterface.findByShopId(shopId);
//        Activity activity = activityServiceInterface.findActivityById(activityId);
//        String sdate = "14-Jul-2011 12:52:00";
//        SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss");
//        Date date = format.parse(sdate);
//        for (Activity a : shop.getActivities()) {
//            if (a.equals(activity)) {
//                Reservation reservation = new Reservation(null, date, shop, myUser);
//                reservationServiceInterface.insertReservation(reservation);
//                 message="successful reservation";
//                break;
//            }
//        }        
//        
//        }
//        else{
//            message="you have no more slots for this shop";}
//
//        return message;
//    }
}
