package com.example.session08_demo.validator;

import com.example.session08_demo.controller.PersonController;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailExisyValidator implements ConstraintValidator<EmailExist,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // false : giu lai va thong bao loi . true cho di qua

        boolean isExist = PersonController.personList
                .stream()
                .anyMatch(p -> p.getEmail().equals(value));
        return !isExist;
    }
}
