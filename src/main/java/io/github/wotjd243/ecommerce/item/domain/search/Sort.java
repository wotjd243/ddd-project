package io.github.wotjd243.ecommerce.item.domain.search;

public class Sort {
    private final SortParameter parameter;
    private final SortOrder order;

    public Sort(SortParameter parameter, SortOrder order) {
        this.parameter = parameter;
        this.order = order;
    }
}
