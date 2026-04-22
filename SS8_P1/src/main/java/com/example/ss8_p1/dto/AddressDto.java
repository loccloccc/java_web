package com.example.ss8_p1.dto;

import jakarta.validation.constraints.NotBlank;

public class AddressDto {

    @NotBlank(message = "Tên người nhận không được thiếu")
    private String receiverName;

    @NotBlank(message = "Địa chỉ chi tiết không được thiếu")
    private String detailedAddress;

    // getters & setters
    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }
}
