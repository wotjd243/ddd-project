package io.github.wotjd243.shoppinggogo.shipping.infra;


import io.github.wotjd243.shoppinggogo.shipping.domain.Shipping;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShippingRepositoryImpl implements ShippingRepository {

    @Override
    public Optional<Shipping> findByShppingNum(final String shippingNum) {
        return Optional.ofNullable(DummyShippingData.get( shippingNum));
    }
}
