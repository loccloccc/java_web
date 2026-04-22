package com.example.session08_demo.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented  // tao ra bai doc de nguoi dung co the hieu
@Constraint(validatedBy = EmailExisyValidator.class) // khi kich hoat validation se goi den lop kiem tra
@Retention(RetentionPolicy.RUNTIME) // kiem tras trong qua trinh chay
@Target({ElementType.FIELD,ElementType.METHOD}) // muc dinh validate o thuoc tinh hay phuong thuc
public @interface EmailExist {
    String message() default "Email da ton tai";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
