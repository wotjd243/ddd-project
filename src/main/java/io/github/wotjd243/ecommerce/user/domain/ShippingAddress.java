package io.github.wotjd243.ecommerce.user.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class ShippingAddress {
    private Long id;
    private String userId;
    private String address;
    private ZipCode zipcode;

    public ShippingAddress(String userId, String address, ZipCode zipcode) {
        if (StringUtils.isBlank(address) || StringUtils.isBlank(userId)) {
            throw new IllegalArgumentException();
        }
        this.userId = userId;
        this.address = address;
        this.zipcode = zipcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingAddress that = (ShippingAddress) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(address, that.address) &&
                Objects.equals(zipcode, that.zipcode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, address, zipcode);
    }
}
