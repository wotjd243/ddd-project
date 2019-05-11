package io.github.wotjd243.ecommerce.order.domain;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class ShoppingBasket {
    public static final String PRICE_FORMAT_PATTERN = "%.2f";
    private final List<ConsideringItem> items;
    private String id;
    private LocalDateTime createdDate;
    private Buyer buyer;

    public ShoppingBasket(Buyer buyer, List<ConsideringItem> items) {
        this.id = UUID.randomUUID().toString();
        this.buyer = buyer;
        this.items = items;
    }

    public double sumPrice() {
        return format(items.stream().map(v -> v.sum()).reduce(0.0, Double::sum));
    }

    public double format(double value) {
        return Double.parseDouble(String.format(PRICE_FORMAT_PATTERN, value));
    }

    public List<String> getItemsName() {
        return items.stream().map(v -> v.getTitle()).collect(Collectors.toList());
    }

    public int size() {
        return items.size();
    }

    public boolean match(String basketId) {
        return this.id == basketId;
    }
}
