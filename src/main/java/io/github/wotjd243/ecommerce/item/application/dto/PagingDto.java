package io.github.wotjd243.ecommerce.item.application.dto;

import io.github.wotjd243.ecommerce.item.domain.search.Page;
import io.github.wotjd243.ecommerce.item.domain.search.Sort;
import io.github.wotjd243.ecommerce.item.domain.search.SortOrder;
import io.github.wotjd243.ecommerce.item.domain.search.SortParameter;

public class PagingDto {
    private final int pageNumber;
    private final int pageSize;
    private final SortParameter sortParameter;
    private final SortOrder sortOrder;

    public PagingDto(int pageNumber, int pageSize, SortParameter sortParameter, SortOrder sortOrder) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.sortParameter = sortParameter;
        this.sortOrder = sortOrder;
    }

    public Sort getSort() {
        return new Sort(this.sortParameter, this.sortOrder);
    }

    public Page getPage() {
        return new Page(this.pageNumber, this.pageSize);
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPageSize() {
        return pageSize;
    }

    public SortParameter getSortParameter() {
        return sortParameter;
    }

    public SortOrder getSortOrder() {
        return sortOrder;
    }
}
