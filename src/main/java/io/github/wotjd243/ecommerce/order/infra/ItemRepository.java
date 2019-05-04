package io.github.wotjd243.ecommerce.order.infra;

import io.github.wotjd243.ecommerce.product.domain.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemRepository {

    private static List<Item> items = new ArrayList<>();

    static {
        Item item1 = new Item("DDD Start", 25.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg");
        items.add(item1);

        Item item2 = new Item("도메인 주도 설계 구현", 23.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/139.jpg");
        items.add(item2);
    }

    public static List<Item> findByKeywords(String keywords) {
        return items.stream().filter(item -> item.match(keywords)).collect(Collectors.toList());
    }
}
