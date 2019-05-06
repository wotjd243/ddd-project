package io.github.wotjd243.shoppinggogo.product.infra;

import io.github.wotjd243.shoppinggogo.product.domain.Category;
import io.github.wotjd243.shoppinggogo.product.domain.PriceRecord;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.domain.ProductImage;

import java.util.*;

public class DummayProductsData {
    private static final Map<Long, Product> products = new HashMap<>();

    static {
        List<PriceRecord> price1s = new ArrayList<>();
        price1s.add(new PriceRecord(1L, 10, 30, 20,
                new Date(), new Date()));
        price1s.add(new PriceRecord(2L,11, 31, 21, new Date(), new Date()));
        price1s.add(new PriceRecord(3L, 12, 32, 22, new Date(), new Date()));
        put(    1L, "DDD 프로젝트",  new Category("강의", "프로그래밍"),
                new ProductImage(1000L, 1L, "/ddd/project/link", "file.jpg", new Date()),
                price1s,
                new Date(), new Date());

        List<PriceRecord> price2s = new ArrayList<>();
        price2s.add(new PriceRecord(1L, 100, 300, 200,
                new Date(), new Date()));
        put(    2L, "포켓몬스터",  new Category("강의", "프로그래밍"),
                new ProductImage(2000L, 2L, "/pocket", "monster.jpg", new Date()),
                price2s,
                new Date(), new Date());
    }

    public static Product get(final Long id) {
        return products.get(id);
    }

    public static Product put(final long id, final String name,
                              final Category category,
                              final ProductImage productImage,
                              final List<PriceRecord> prices,
                              final Date createDate, final Date updateDate) {
        return products.put(id, new Product(id, name, category, productImage,
                prices, createDate, updateDate));
    }
}
