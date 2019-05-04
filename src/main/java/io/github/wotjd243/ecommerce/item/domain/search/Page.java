package io.github.wotjd243.ecommerce.item.domain.search;

public class Page {
    private final int pageNumber;
    private final int pageSize;

    public Page(int pageNumber, int pageSize) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }
}
