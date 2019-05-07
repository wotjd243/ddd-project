package io.github.wotjd243.ecommerce.item.domain.search;

public enum SortOrder {
    ASCENDING,
    DESCENDING;

    public boolean isDescending() {
        return (this == DESCENDING);
    }
}
