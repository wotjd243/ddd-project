package io.github.wotjd243.shoppinggogo.shipping.domain;

import java.util.Optional;

public interface ShippingRepository {
    Optional<Shipping> findByShppingId(final Long shppingId);
    boolean saveShpping(final Shipping shpping);
    boolean updateShipping(final Shipping shipping);

}