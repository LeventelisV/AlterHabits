/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.webapp.groupproject.annotations;

import com.webapp.groupproject.validators.ImageSizeValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

/**
 *
 * @author alexk
 */
@Documented
@Constraint(validatedBy = {ImageSizeValidator.class})
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ImageSizeConstraint {
    String message() default "The size of the image is too big. Insert a smaller one.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
