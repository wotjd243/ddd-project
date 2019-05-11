package io.github.wotjd243.ecommerce.item.domain.search;

import io.github.wotjd243.ecommerce.item.domain.Item;
import io.github.wotjd243.ecommerce.item.infra.DummyItemRepository;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class SortTest {

    @Test
    public void item_소팅_금액_별() {
        // given
        List<Item> allItems = new ArrayList<>(new DummyItemRepository().findAll());
        Sort sort = new Sort(SortParameter.PRICE, SortOrder.DESCENDING);

        // when
        List<Item> sortedItems = sort.sortItems(allItems);

        // then
        List<Double> prices = sortedItems.stream()
                .map(Item::getPrice)
                .collect(Collectors.toList());
        assertThat(prices).isSortedAccordingTo(Comparator.reverseOrder());
    }

    @Test
    public void item_소팅_title_별() {
        // given
        List<Item> allItems = new ArrayList<>(new DummyItemRepository().findAll());
        Sort sort = new Sort(SortParameter.TITLE, SortOrder.ASCENDING);

        // when
        List<Item> sortedItems = sort.sortItems(allItems);

        // then
        List<String> titles = sortedItems.stream()
                .map(Item::getTitle)
                .collect(Collectors.toList());
        assertThat(titles).isSorted();
    }
}
