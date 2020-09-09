/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.validators;

import com.webapp.groupproject.annotations.ImageFileConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author alexk
 */
public class ImageFileValidator implements ConstraintValidator<ImageFileConstraint, MultipartFile> {

    @Override
    public void initialize(ImageFileConstraint image) {
    }

    @Override
    public boolean isValid(MultipartFile image, ConstraintValidatorContext cvc) {
            String extension = FilenameUtils.getExtension(image.getOriginalFilename());
            return extension.equals("jpg") || extension.equals("png");
        }
    }
