package com.FullStackApp.WebServices.user;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = {UniqueDisplayNameValidator.class})
public @interface UniqueDisplayName {
    String message() default "has already been taken. Display name must be unique.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
