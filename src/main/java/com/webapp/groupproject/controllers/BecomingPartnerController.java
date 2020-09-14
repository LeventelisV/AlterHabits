/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.Activity;
import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.services.ActivityServiceInterface;
import com.webapp.groupproject.services.ShopServiceInterface;
import com.webapp.groupproject.utils.BASE64DecodedMultipartFile;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vaggelis
 */
@RestController
public class BecomingPartnerController {

    @Autowired
    ActivityServiceInterface activityServiceInterface;

    @Autowired
    ShopServiceInterface shopServiceInterface;

    public String verifyFuturePartner(@RequestParam String shopName,
            @RequestParam String activity,
            @RequestParam String longitude,
            @RequestParam String shopPhoto,
            @RequestParam String latitude) {
        if ((activityServiceInterface.findIfAnActivityExists(activity)) && (shopServiceInterface.findIfAShopNameDoesNotExists(shopName))) {
            return "forward:insertPartner";
        } else {
            return "invalid name or wrong activity";
        }
    }

    @GetMapping("/insertPartner")
    public String insertNewPartner(@RequestParam String shopName,
            @RequestParam List<String> activities,
            @RequestParam String longitude,
            @RequestParam String shopPhoto,
            @RequestParam String latitude) {
        List<Activity> act= new ArrayList();
       for(String s : activities){
     Activity a=  activityServiceInterface.findActivityByName(s);
       }
        
      //  Shop shop=new Shop(shopName,activities,longitude,latitude)
        
        return "";
    }

    
    
    
    
    
    
    @GetMapping("/insertPartner2")
    public void saveImage() throws IOException {
         String shop = "C:\\Users\\vaggelis\\Downloads\\comradery.jpg";
        byte[] fileContent = FileUtils.readFileToByteArray(new File(shop));
        String encodedString = Base64.getEncoder().encodeToString(fileContent);


        byte[] byteBase64Decoded = Base64.getDecoder().decode(encodedString);
        String stringBase64Decoded = new String(byteBase64Decoded);


        MultipartFile f = BASE64DecodedMultipartFile.base64ToMultipart(stringBase64Decoded);
        
        
        String s="";
        
        
        
        
        
        
        
        
 //       String shop = "C:\\Users\\vaggelis\\Downloads\\comradery.jpg";
//        byte[] fileContent = FileUtils.readFileToByteArray(new File(shop));
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);

//        BufferedImage image = null;
//        byte[] decodedBytes = Base64.getMimeDecoder().decode((shop).split(",")[1]);
//
//        ByteArrayInputStream bis = new ByteArrayInputStream(decodedBytes);
//        image = ImageIO.read(bis);
//        bis.close();
//
//        File outputfile = new File(("C:\\Users\\vaggelis\\kkk\\"));
//
//        ImageIO.write(image, "jpg", outputfile);

        // user.setPhotoUrl(signupdto.getPhotoname());
    }

}
//    String shop = "C:\\Users\\vaggelis\\Downloads\\comradery.jpg";
//        byte[] fileContent = FileUtils.readFileToByteArray(new File(shop));
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//
//       
//
//        MultipartFile f = BASE64DecodedMultipartFile.base64ToMultipart(encodedString);
//        return f;
