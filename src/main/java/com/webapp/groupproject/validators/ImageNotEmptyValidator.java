/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.validators;

import com.webapp.groupproject.annotations.ImageNotEmptyConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexk
 */
public class ImageNotEmptyValidator implements ConstraintValidator<ImageNotEmptyConstraint, MultipartFile>{

    @Override
    public void initialize(ImageNotEmptyConstraint constraintAnnotation) {
    }

    @Override
    public boolean isValid(MultipartFile usersPhoto, ConstraintValidatorContext cvc) {
        return usersPhoto.getSize() != 0;
    }
    
}
