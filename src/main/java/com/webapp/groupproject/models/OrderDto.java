/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 *
 * @author vaggelis
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDto {
    
    private double price;
    private String currency;
    private String method;
    private String intent;
    private String description;
    
}
