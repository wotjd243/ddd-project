package io.github.wotjd243.shoppinggogo.cart.infra;

import io.github.wotjd243.shoppinggogo.cart.domain.Cart;
import io.github.wotjd243.shoppinggogo.product.domain.Category;
import io.github.wotjd243.shoppinggogo.product.domain.PriceRecord;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.domain.ProductImage;

import java.util.*;

public class DummyCartData {

    private static final Map<Long, Cart> carts = new HashMap<>();

    static {
        //상품 목록
        List<Product> product1s = new ArrayList<>();
        List<Product> product2s = new ArrayList<>();

        //상품가격 및 상품
        PriceRecord price1 = new PriceRecord(11,31,21, new Date(), new Date());
        Product product01 = new Product(1L,"DDD 프로젝트", new Category("강의", "프로그래밍"),
                new ProductImage(1000L, 1L, "/ddd/project/link", "file.jpg", new Date()),
                price1,
                new Date(), new Date());

        PriceRecord price2 = new PriceRecord(100, 300, 200, new Date(), new Date());
        Product product02 = new Product(2L, "포켓몬스터",  new Category("강의", "프로그래밍"),
                new ProductImage(2000L, 2L, "/pocket", "monster.jpg", new Date()),
                price2,
                new Date(), new Date());


        product1s.add(product01);
        product2s.add(product01);
        product2s.add(product02);

        put(1L, 1L, Arrays.asList(1L));
        put(2L, 2L, Arrays.asList(1L, 2L));
    }

    public static Cart getByUserId(final long userId) {
        return carts.get(userId);
    }

    public static Cart put(final Long id, final long userId, final List<Long> productIds){
        return carts.put(userId, new Cart(id, userId, productIds));
    }
}
