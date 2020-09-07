/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

/**
 *
 * @author vaggelis
 */
public class ShopDto {
    
    private int shopId;
    private String shopName;
    private String shopPhoto;
    private String longitude;
    private String latitude;
    
    public ShopDto() {
    }

    public ShopDto(String shopName) {
        this.shopName = shopName;
    }

    public ShopDto(int shopId, String shopName, String shopPhoto, String longitude, String latitude) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopPhoto = shopPhoto;
        this.longitude = longitude;
        this.latitude = latitude;
    }
    

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getShopId() {
        return shopId;
    }

    public String getShopPhoto() {
        return shopPhoto;
    }

    public String getLongitude() {
        return longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public void setShopPhoto(String shopPhoto) {
        this.shopPhoto = shopPhoto;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
    
    
}
