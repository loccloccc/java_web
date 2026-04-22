package com.example.ss8_p2;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class EmployeeDto {

    @NotNull(message = "Tuổi không được để trống")
    @Min(value = 18, message = "Nhân viên phải từ 18 tuổi trở lên")
    @Max(value = 60, message = "Tuổi tối đa là 60")
    private Integer age;

    // email tương tự với @Email

    // getters & setters
}
