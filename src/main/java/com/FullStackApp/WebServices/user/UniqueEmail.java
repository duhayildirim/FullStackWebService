package com.FullStackApp.WebServices.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueEmailValidator.class})
public @interface UniqueEmail {
    String message() default "has already been taken.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
