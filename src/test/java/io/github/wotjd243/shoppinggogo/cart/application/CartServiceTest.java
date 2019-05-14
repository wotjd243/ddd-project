package io.github.wotjd243.shoppinggogo.cart.application;

import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.cart.infra.DummyCartData;
import io.github.wotjd243.shoppinggogo.product.domain.Category;
import io.github.wotjd243.shoppinggogo.product.domain.PriceRecord;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.domain.ProductImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@RunWith(MockitoJUnitRunner.class)
public class CartServiceTest {

    @Mock
    private CartRepository cartRepository;


    @InjectMocks
    private CartService cartService;

    @Test
    public void 유저ID_test일경우_결과값은_ProductID_1() {
        // given
        // 테스트 환경 만들기 (mock에 대한 설정 등등)
        given(cartRepository.findCartByUserId(1L))
                .willReturn(DummyCartData.getByUserId(1L));
        // when
        // 테스트
        final List<Long> results = cartService.findProductIdsFromCart(1L);
        // then
        // 테스트 결과에 대한 검증
        assertThat(results)
                .containsAnyOf(1L);
    }
}
