package io.github.wotjd243.ecommerce.item.infra;

import io.github.wotjd243.ecommerce.item.application.dto.PagingDto;
import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.domain.ItemDetail;
import io.github.wotjd243.ecommerce.item.domain.ItemRepository;
import io.github.wotjd243.ecommerce.item.domain.Stock;
import io.github.wotjd243.ecommerce.item.domain.search.Page;
import io.github.wotjd243.ecommerce.item.domain.search.QueryKeyword;
import io.github.wotjd243.ecommerce.item.domain.search.Sort;
import io.github.wotjd243.ecommerce.user.infra.DummyUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class DummyItemRepository implements ItemRepository {
    private static String user = DummyUserRepository.getTestUserId();
    private static List<Item> items = new ArrayList<>();

    static {
        ItemDetail itemDetail1 = new ItemDetail( "DDD Start", 25.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg");
        Item item1 = new Item(1L, user, new Stock(1), itemDetail1);
        items.add(item1);

        ItemDetail itemDetail2 = new ItemDetail("도메인 주도 설계 구현", 23.00, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/139.jpg");
        Item item2 = new Item(2L, user, new Stock(1), itemDetail2);
        items.add(item2);

        ItemDetail itemDetail3 = new ItemDetail("자바 성능 튜닝 이야기", 17.50, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/138.jpg");
        Item item3 = new Item(3L, user, new Stock(1), itemDetail3);
        items.add(item3);

        ItemDetail itemDetail4 = new ItemDetail("자바 네트워크 소녀 Netty", 60.23, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/137.jpg");
        Item item4 = new Item(4L, user, new Stock(1), itemDetail4);
        items.add(item4);

        LongStream.rangeClosed(5, 20)
                .forEach(i -> {
                    ItemDetail dummyItemDetail = new ItemDetail("Dummy Item " + i, (double) i, "http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/" + i + ".jpg");
                    Item dummyItem = new Item(i, user, new Stock(1), dummyItemDetail);
                    items.add(dummyItem);
                });
    }

    @Override
    public Item findById(Long itemId) {
        return items.stream().filter(v -> v.getId() == itemId).findFirst().get();
    }

    @Override
    public List<Item> findByUserId(String userId) {
        return items.stream()
                .filter(v -> v.getSellerId() == userId)
                .collect(Collectors.toList());
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public List<Item> findAll(PagingDto paging) {
        Sort sort = paging.getSort();
        List<Item> sortedItems = sort.sortItems(new ArrayList<>(items));

        Page page = paging.getPage();
        return page.getPageElements(sortedItems);
    }

    @Override
    public List<Item> findByQueryKeyword(QueryKeyword queryKeyword, PagingDto paging) {
        List<Item> filteredItems = items.stream()
                .filter(item -> item.isKeywordMatched(queryKeyword))
                .collect(Collectors.toList());

        Sort sort = paging.getSort();
        List<Item> sortedItems = sort.sortItems(filteredItems);

        Page page = paging.getPage();
        return page.getPageElements(sortedItems);
    }

    @Override
    public Item save(Item item) {
        items.add(item);
        return item;
    }
}
