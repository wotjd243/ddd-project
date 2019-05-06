package io.github.wotjd243.ecommerce.user.domain;

import io.github.wotjd243.ecommerce.user.domain.ShippingAddress;

import java.util.List;

public interface ShippingAddressRepository {
    ShippingAddress save(ShippingAddress shippingAddress);

    List<ShippingAddress> findAllByUserId(String userId);
}