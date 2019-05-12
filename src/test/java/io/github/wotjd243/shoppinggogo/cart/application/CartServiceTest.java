package io.github.wotjd243.shoppinggogo.cart.application;

import io.github.wotjd243.shoppinggogo.cart.infra.CartRepository;
import io.github.wotjd243.shoppinggogo.product.domain.Category;
import io.github.wotjd243.shoppinggogo.product.domain.PriceRecord;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.domain.ProductImage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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

        List<Long> product1s = Arrays.asList(1L,2L,3L);

        given(cartRepository.selectProductsToCart(1L).stream()
                .collect(Collectors.toList()))
                .willReturn(product1s);

        final List<Long> results = cartService.findProductsToCart(1L);

        assertThat(results)
                .containsAnyOf(1L);
    }
}
