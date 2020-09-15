/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import java.util.List;

/**
 *
 * @author alexk
 */
public class PartnerDto {

     private String shopName;
     private String shopEmail;
     private String shopLatitude;
     private String shopLongitude;
     private String shopImage;
     private List<String> shopActivities;
     
     public PartnerDto(){}

    public PartnerDto(String shopName, String shopEmail, String shopLatitude, String shopLongitude, String shopImage, List<String> shopActivities) {
        this.shopName = shopName;
        this.shopEmail = shopEmail;
        this.shopLatitude = shopLatitude;
        this.shopLongitude = shopLongitude;
        this.shopImage = shopImage;
        this.shopActivities = shopActivities;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopEmail() {
        return shopEmail;
    }

    public void setShopEmail(String shopEmail) {
        this.shopEmail = shopEmail;
    }

    public String getShopLatitude() {
        return shopLatitude;
    }

    public void setShopLatitude(String shopLatitude) {
        this.shopLatitude = shopLatitude;
    }

    public String getShopLongitude() {
        return shopLongitude;
    }

    public void setShopLongitude(String shopLongitude) {
        this.shopLongitude = shopLongitude;
    }

    public String getShopImage() {
        return shopImage;
    }

    public void setShopImage(String shopImage) {
        this.shopImage = shopImage;
    }

    public List<String> getShopActivities() {
        return shopActivities;
    }

    public void setShopActivities(List<String> shopActivities) {
        this.shopActivities = shopActivities;
    }


}
