package com.example.ss8_p3;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


public class WithdrawRequestDto {

    @NotNull(message = "withdrawAmount is required")
    @Min(value = 50_000, message = "withdrawAmount must be at least 50,000 VND")
    @MultipleOfTenThousand
    private Long withdrawAmount;

    public WithdrawRequestDto() {
    }

    public WithdrawRequestDto(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }

    public Long getWithdrawAmount() {
        return withdrawAmount;
    }

    public void setWithdrawAmount(Long withdrawAmount) {
        this.withdrawAmount = withdrawAmount;
    }
}