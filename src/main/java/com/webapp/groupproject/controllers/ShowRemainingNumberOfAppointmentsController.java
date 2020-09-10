/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.Reservation;
import com.webapp.groupproject.utils.BookingUtils;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author vaggelis
 */
@RestController
public class ShowRemainingNumberOfAppointmentsController {

    @Autowired
    BookingUtils bookingUtils;

    @GetMapping("/showRemainingAppointments")
    public int showRemainingAppointments() {
        MyUser myUser = bookingUtils.takeTheLoggedInUser();
        return bookingUtils.showNumberOfRemainingAppointments(myUser.getUserId(), myUser.getRoleId());

    }

}
