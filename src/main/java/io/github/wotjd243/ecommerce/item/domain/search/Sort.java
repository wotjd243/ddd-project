package io.github.wotjd243.ecommerce.item.domain.search;

import io.github.wotjd243.ecommerce.item.domain.Item;

import java.util.Collections;
import java.util.List;

public class Sort {
    private final SortParameter parameter;
    private final SortOrder order;

    public Sort(SortParameter parameter, SortOrder order) {
        this.parameter = parameter;
        this.order = order;
    }

    public List<Item> sortItems(List<Item> items) {
        Collections.sort(items, this.parameter.getItemComparator());

        if (this.order.isDescending()) {
            Collections.reverse(items);
        }

        return items;
    }
}
