package com.example.ss8_p3;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = MultipleOfTenThousandValidator.class)
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface MultipleOfTenThousand {
    String message() default "withdrawAmount must be a multiple of 10,000 VND";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}