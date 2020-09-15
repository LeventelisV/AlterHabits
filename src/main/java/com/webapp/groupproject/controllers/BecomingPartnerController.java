/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.Activity;
import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.services.ActivityServiceInterface;
import com.webapp.groupproject.services.FileHandlingServiceInterface;
import com.webapp.groupproject.services.ShopServiceInterface;
import com.webapp.groupproject.utils.BASE64DecodedMultipartFile;
import com.webapp.groupproject.utils.HelperMethods;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Autowired
    FileHandlingServiceInterface fileHandlingServiceInterface;

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
            @RequestParam List<String> stringActivities,
            @RequestParam String longitude,
            @RequestParam String shopPhoto,
            @RequestParam String latitude) {
        List<Activity> activities = new ArrayList();
        for (String s : stringActivities) {
            Activity a = activityServiceInterface.findActivityByName(s);
            activities.add(a);

        }

        Shop shop = new Shop(shopName, activities, longitude, latitude);
        Shop insertedShop = shopServiceInterface.insertShop(shop);
        byte[] byteBase64Decoded = Base64.getDecoder().decode(shopPhoto);
        String stringBase64Decoded = new String(byteBase64Decoded);
        MultipartFile f = BASE64DecodedMultipartFile.base64ToMultipart(stringBase64Decoded);
        fileHandlingServiceInterface.storeFileToDisk(f, insertedShop.getShopId() + ".jpg");
//  Shop shop=new Shop(shopName,activities,longitude,latitude)
        return " ";
    }

    @GetMapping("/insertPartner2")
    public void saveImage( ) throws IOException {
         String shop = "C:\\Users\\vaggelis\\Downloads\\comradery.jpg";
//        String newshop="C:\\Users\\vaggelis";
//        
//         byte[] fileContent = FileUtils.readFileToByteArray(new File(shop));
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);
 //       System.out.println(image);
        byte[] byteBase64Decoded = Base64.getDecoder().decode(shop);
         String folder="\\Users\\vaggelis\\downloads\\"   ;
         Path path=Paths.get(folder+"dfgh.jpg");
         Files.write(path,byteBase64Decoded);
    
    
        
        
        
        
        
        
        
        

//        byte[] fileContent = FileUtils.readFileToByteArray(new File(shop));
//        String encodedString = Base64.getEncoder().encodeToString(fileContent);
//
//        byte[] byteBase64Decoded = Base64.getDecoder().decode(encodedString);
//        String stringBase64Decoded = new String(byteBase64Decoded);
//
//        MultipartFile f = BASE64DecodedMultipartFile.base64ToMultipart(stringBase64Decoded);
//         fileHandlingServiceInterface.storeFileToDisk(f, "adhjdha.jpg");
//       
//        HelperMethods.multipartFileToFile(f, newshop);
//        
//        f.transferTo(new File(newshop));
//         

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
