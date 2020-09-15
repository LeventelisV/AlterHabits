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
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.multipart.MultipartFile;
import sun.misc.BASE64Decoder;
import java.nio.file.Path;
import java.nio.file.Paths;

 


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
    
//    public static MultipartFile  decodeABase64String(String base64){
//        try {
//            String[] baseStrs = base64.split(",");
// 
//            BASE64Decoder decoder = new BASE64Decoder();
//            byte[] b = new byte[0];
//            b = decoder.decodeBuffer(baseStrs[1]);
// 
//            for (int i = 0; i < b.length; ++i) {
//                if (b[i] < 0) {
//                    b[i] += 256;
//                }
//            }
// 
//            return new BASE64DecodedMultipartFile(b, baseStrs[0]);
//        } catch (IOException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public static MultipartFile convertBase64ToMultipart(String encodedString) {

        byte[] byteBase64Decoded = Base64.getDecoder().decode(encodedString);
        String stringBase64Decoded = new String(byteBase64Decoded);

        return BASE64DecodedMultipartFile.base64ToMultipart(stringBase64Decoded);

    }

    public static String manipulateDateString(String requestString) {
        String[] parts = requestString.split("GMT ", 2);
        String part1 = parts[0]; // 004
        String part2 = parts[1]; // 034556-42
        return (part1 + "GMT+" + part2);


        
        
    }
}
