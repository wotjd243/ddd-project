package io.github.wotjd243.shoppinggogo.seller.infra;

import io.github.wotjd243.shoppinggogo.seller.domain.Seller;
import io.github.wotjd243.shoppinggogo.seller.domain.SellerRepository;
import io.github.wotjd243.shoppinggogo.user.domain.User;
import io.github.wotjd243.shoppinggogo.user.domain.UserRepository;
import io.github.wotjd243.shoppinggogo.user.infra.DummyUserData;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class DummySellerRepository implements SellerRepository {

    @Override
    public Optional<Seller> findBySellerId(Long sellerId) {
        return Optional.ofNullable(DummySellerData.get(sellerId));
    }
}
