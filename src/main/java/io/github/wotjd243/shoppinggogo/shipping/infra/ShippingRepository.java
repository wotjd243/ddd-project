package io.github.wotjd243.shoppinggogo.shipping.infra;


import io.github.wotjd243.shoppinggogo.shipping.domain.Shipping;
import io.github.wotjd243.shoppinggogo.shipping.domain.IShippingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ShippingRepository implements IShippingRepository {

    @Override
    public Optional<Shipping> findByShppingNum(final String shippingNum) {
        return Optional.ofNullable(DummyShippingData.get( shippingNum));
    }
}
