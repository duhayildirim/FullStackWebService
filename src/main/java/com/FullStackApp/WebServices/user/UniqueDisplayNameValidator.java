package com.FullStackApp.WebServices.user;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueDisplayNameValidator implements ConstraintValidator<UniqueDisplayName, String> {
    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        User user = userRepository.findByDisplayName(value);

        return user == null ? true : false;
    }
}
