package com.example.ss8_p3;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MultipleOfTenThousandValidator implements ConstraintValidator<MultipleOfTenThousand, Long> {
    private static final long STEP = 10_000L;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            // Let @NotNull handle null explicitly.
            return true;
        }
        return value % STEP == 0;
    }
}