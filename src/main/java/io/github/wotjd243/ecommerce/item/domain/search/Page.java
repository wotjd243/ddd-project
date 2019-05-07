package io.github.wotjd243.ecommerce.item.domain.search;

import java.util.Collections;
import java.util.List;

public class Page {
    private static final int MIN_PAGE_VALUE = 1;

    private final int pageNumber;
    private final int pageSize;

    public Page(int pageNumber, int pageSize) {
        validatePageNumber(pageNumber);
        validatePageSize(pageSize);

        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
    }

    public <T> List<T> getPageElements(List<T> list) {
        int lastIndexOfItems = list.size() - 1;
        int pageStartIndex = (pageNumber - 1) * pageSize;

        if (lastIndexOfItems < pageStartIndex) {
            return Collections.emptyList();
        }

        int pageEndIndex = pageStartIndex + pageSize;

        if (lastIndexOfItems < pageEndIndex) {
            pageEndIndex = lastIndexOfItems + 1;
        }

        return list.subList(pageStartIndex, pageEndIndex);
    }

    private void validatePageSize(int pageSize) {
        if (pageSize < MIN_PAGE_VALUE) {
            throw new IllegalArgumentException("Min value for page is " + MIN_PAGE_VALUE);
        }
    }

    private void validatePageNumber(int pageNumber) {
        if (pageNumber < MIN_PAGE_VALUE) {
            throw new IllegalArgumentException("Min value for page is " + MIN_PAGE_VALUE);
        }
    }
}
