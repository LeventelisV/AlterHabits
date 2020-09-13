/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.validators;

import com.webapp.groupproject.annotations.ImageSizeConstraint;
import com.webapp.groupproject.utils.BASE64DecodedMultipartFile;
import com.webapp.groupproject.utils.HelperMethods;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexk
 */
public class ImageSizeValidator implements ConstraintValidator<ImageSizeConstraint, String> {

    @Override
    public void initialize(ImageSizeConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(String image, ConstraintValidatorContext cvc) {
        
            if (HelperMethods.convertBase64ToMultipart(image).getSize() > 225443840) {
                return false;
            }
            return true;
    }
    
}
