package io.github.wotjd243.ecommerce.user.application;

import io.github.wotjd243.ecommerce.user.application.dto.ShippingAddressDto;
import io.github.wotjd243.ecommerce.user.domain.ShippingAddress;

public class UserService {

    private ShippingAddressService shippingAddressService;

    public UserService(ShippingAddressService shippingAddressService) {
        this.shippingAddressService = shippingAddressService;
    }

    public ShippingAddress addShippingAddress(String userId, ShippingAddressDto shippingAddressDto) {
        return shippingAddressService.addShippingAddress(userId, shippingAddressDto);
    }
}
