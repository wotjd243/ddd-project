package io.github.wotjd243.support.ecommerce.product;

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

        Item item3 = new Item("자바 성능 튜닝 이야기", 17.50, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/138.jpg");
        items.add(item3);

        Item item4 = new Item("자바 네트워크 소녀 Netty", 60.23, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/137.jpg");
        items.add(item4);
    }

    public static List<Item> findByKeywords(String keywords) {
        return items.stream().filter(item -> item.match(keywords)).collect(Collectors.toList());
    }
}
