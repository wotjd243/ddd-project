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
        carts.put(1L,         new Cart(1L, 1L, product1s, Arrays.asList(1L)));

        List<Product> product2s = new ArrayList<>();
        List<PriceRecord> price2s = new ArrayList<>();
        price2s.add(new PriceRecord(1L, 100, 300, 200,
                new Date(), new Date()));
        product2s.add(new Product(    2L, "포켓몬스터",  new Category("강의", "프로그래밍"),
                new ProductImage(2000L, 2L, "/pocket", "monster.jpg", new Date()),
                price2s,
                new Date(), new Date()));
        carts.put(2L,         new Cart(2L, 2L, product2s, Arrays.asList(2L)));
    }

    public static Cart getByUserId(final long userId) {
        return carts.get(userId);
    }

    public static Cart put(final Long id, final long userId, final List<Product> products,
                           final List<Long> checkedProducts) {
        return carts.put(userId, new Cart(id, userId, products, checkedProducts));
    }
}
