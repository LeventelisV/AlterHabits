/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.services;

import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author vaggelis
 */
public interface FileHandlingServiceInterface {
    
    
     
     
    public  String storeFileToDisk(MultipartFile file, String filename);
    
}
