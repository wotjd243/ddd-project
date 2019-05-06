package io.github.wotjd243.shoppinggogo.shipping.domain;

import java.util.Optional;

public interface IShippingRepository {
    Optional<Shipping> findByShppingNum(final String shippingNum);
}
