/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.utils;

import com.webapp.groupproject.SpringContext;
import com.webapp.groupproject.models.CreditDebitCard;
import com.webapp.groupproject.models.MyUser;
import com.webapp.groupproject.models.UserContactInfo;
import com.webapp.groupproject.services.CreditDebitCardServiceInterface;
import com.webapp.groupproject.services.MyUserServiceInterface;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 *
 * @author vaggelis
 */
public class HelperMethods {

    private CreditDebitCardServiceInterface getCreditDebitCardService() {
        return SpringContext.getBean(CreditDebitCardServiceInterface.class);
    }

    private MyUserServiceInterface getMyUserService() {
        return SpringContext.getBean(MyUserServiceInterface.class);
    }

    public static Date parseStringToDate(String s) {

        Date date = null;
        try {
             DateFormat inputFormat = new SimpleDateFormat(
                "E MMM dd yyyy HH:mm:ss 'GMT'z", Locale.ENGLISH);
        date = inputFormat.parse(s);
        System.out.println(date);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return date;

    }

}
