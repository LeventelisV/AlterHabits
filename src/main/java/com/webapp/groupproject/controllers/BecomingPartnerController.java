/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.controllers;

import com.webapp.groupproject.models.Activity;
import com.webapp.groupproject.models.ImageDto;
import com.webapp.groupproject.models.Shop;
import com.webapp.groupproject.services.ActivityServiceInterface;
import com.webapp.groupproject.services.ShopServiceInterface;
import com.webapp.groupproject.utils.BASE64DecodedMultipartFile;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
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
        List<Activity> act = new ArrayList();
        for (String s : activities) {
            Activity a = activityServiceInterface.findActivityByName(s);
        }

        //  Shop shop=new Shop(shopName,activities,longitude,latitude)
        return "";
    }

    @PostMapping("/insertPartner2")
    public void saveImage(@RequestBody ImageDto userPhoto) throws IOException {

//
//
        byte[] byteBase64Decoded = Base64.getDecoder().decode(userPhoto.getUserPhoto());
        String stringBase64Decoded = new String(byteBase64Decoded);
//
        OutputStream out = new FileOutputStream("E:\\Downloads\\UsersPhotos\\122.jpg");
        out.write(byteBase64Decoded);
        out.close();
    }

}
