package io.github.wotjd243.ecommerce.item.domain.search;

import io.github.wotjd243.ecommerce.item.domain.Item;

import java.util.Comparator;

public enum SortParameter {
    TITLE((a, b) -> a.getTitle().compareTo(b.getTitle())),
    PRICE((a, b) -> Double.compare(a.getPrice(), b.getPrice()));

    private Comparator<Item> itemComparator;

    SortParameter(Comparator<Item> itemComparator) {
        this.itemComparator = itemComparator;
    }

    public Comparator<Item> getItemComparator() {
        return itemComparator;
    }
}
