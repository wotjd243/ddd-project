package io.github.wotjd243.ecommerce.user.application.dto;

public class ShippingAddressDto {
    private final String address;
    private final String zipCode;

    public ShippingAddressDto(String address, String zipCode) {
        this.address = address;
        this.zipCode = zipCode;
    }

    public String getAddress() {
        return address;
    }

    public String getZipCode() {
        return zipCode;
    }
}