/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.helperMethods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author vaggelis
 */
public class HelperMethods {

    public static Date parseStringToDate(String s) throws ParseException {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(s);

        return date;

    }

}
