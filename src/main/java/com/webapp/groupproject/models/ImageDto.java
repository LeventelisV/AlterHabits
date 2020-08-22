/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.models;

import com.webapp.groupproject.annotations.ImageFileConstraint;
import com.webapp.groupproject.annotations.ImageSizeConstraint;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexk
 */
public class ImageDto {
    
    @ImageFileConstraint
    @ImageSizeConstraint
    private MultipartFile userPhoto;

    public ImageDto() {
    }

    public ImageDto(MultipartFile userPhoto) {
        this.userPhoto = userPhoto;
    }

    public MultipartFile getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(MultipartFile userPhoto) {
        this.userPhoto = userPhoto;
    }
    
}
