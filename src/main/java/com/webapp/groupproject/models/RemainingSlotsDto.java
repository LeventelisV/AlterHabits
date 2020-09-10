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
public class RemainingSlotsDto {
    
    String shopName;
    int slots;

    public RemainingSlotsDto(String shopName, int slots) {
        this.shopName = shopName;
        this.slots = slots;
    }
    
    
}
