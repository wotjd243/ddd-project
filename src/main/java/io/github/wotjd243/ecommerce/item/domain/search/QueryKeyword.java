package io.github.wotjd243.ecommerce.item.domain.search;

public class QueryKeyword {
    private static final int MIN_KEYWORD_LENGTH = 3;

    private final String keyword;

    public QueryKeyword(String keyword) {
        validateKeyword(keyword);

        this.keyword = keyword;
    }

    public boolean match(String title) {
        return title.contains(keyword);
    }

    private void validateKeyword(String keyword) {
        if (keyword.length() < MIN_KEYWORD_LENGTH) {
            throw new IllegalArgumentException("Keyword length must be at least " + MIN_KEYWORD_LENGTH);
        }
    }
}
