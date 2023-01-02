package com.practice.demo.annotation;

import com.practice.demo.validator.ArgValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;
@Documented
@Target({ METHOD, FIELD, CONSTRUCTOR, PARAMETER, TYPE_USE })
@Constraint(validatedBy = ArgValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface ArgReq {
    String message() default "this dto is not allowed";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
