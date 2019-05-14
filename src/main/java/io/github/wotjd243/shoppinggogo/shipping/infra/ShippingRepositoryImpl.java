package io.github.wotjd243.shoppinggogo.shipping.infra;


import io.github.wotjd243.shoppinggogo.shipping.domain.Shipping;
import io.github.wotjd243.shoppinggogo.shipping.domain.ShippingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShippingRepositoryImpl implements ShippingRepository {

    @Override
    public Optional<Shipping> findByShppingId(final Long shippingId) {
        return Optional.ofNullable(DummyShippingData.get(shippingId));
    }

    @Override
    public boolean saveShpping(Shipping shpping) {
        return DummyShippingData.save(shpping);
    }

    @Override
    public boolean updateShipping(Shipping shipping) {
        return DummyShippingData.update(shipping);
    }

}
