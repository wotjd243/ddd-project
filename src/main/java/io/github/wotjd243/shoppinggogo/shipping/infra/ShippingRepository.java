package io.github.wotjd243.shoppinggogo.shipping.infra;

import io.github.wotjd243.shoppinggogo.shipping.domain.Shipping;

import java.util.Optional;

public interface ShippingRepository {
    Optional<Shipping> findByShppingNum(final String shippingNum);
}