package io.github.wotjd243.shoppinggogo.cart.application;

import io.github.wotjd243.shoppinggogo.cart.domain.Cart;
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

        List<Product> product1s = new ArrayList<>();
        List<PriceRecord> price1s = new ArrayList<>();
        price1s.add(new PriceRecord(1L, 10, 30, 20,
                new Date(), new Date()));
        price1s.add(new PriceRecord(2L,11, 31, 21, new Date(), new Date()));
        price1s.add(new PriceRecord(3L, 12, 32, 22, new Date(), new Date()));

        product1s.add(new Product(    1L, "DDD 프로젝트",  new Category("강의", "프로그래밍"),
                new ProductImage(1000L, 1L, "/ddd/project/link", "file.jpg", new Date()),
                price1s,
                new Date(), new Date()));

        given(cartRepository.selectProductsToCart("test").stream()
                .collect(Collectors.toList()))
                .willReturn(product1s);

        final List<Product> results = cartService.findProductsToCart("test");

        List<Long> s = results.stream().map(product -> product.getId())
                .collect(Collectors.toList());
        assertThat(s)
                .containsAnyOf(1L);
    }
}
