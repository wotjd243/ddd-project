package io.github.wotjd243.shoppinggogo.product.infra;

import io.github.wotjd243.shoppinggogo.product.domain.Category;
import io.github.wotjd243.shoppinggogo.product.domain.PriceRecord;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import io.github.wotjd243.shoppinggogo.product.domain.ProductImage;

import java.util.*;

public class DummayProductsData {
    private static final Map<Long, Product> products = new HashMap<>();

    static {
        List<PriceRecord> price1s = new ArrayList<>();
        price1s.add(new PriceRecord(1L, 10, 30, 20,
                new Date(), new Date()));
        price1s.add(new PriceRecord(2L,11, 31, 21, new Date(), new Date()));
        price1s.add(new PriceRecord(3L, 12, 32, 22, new Date(), new Date()));
        put(    1L, "DDD 프로젝트",  new Category("강의", "프로그래밍"),
                new ProductImage(1000L, 1L, "/ddd/project/link", "file.jpg", new Date()),
                price1s,
                new Date(), new Date());

    }

    private long id;
    private long productId; //제품 아이디
    private String imageLink; //이미지 링크
    private String imageFile; //이미지 파일
    private Date modifyDate; //수정된 날짜


    public static Product get(final Long id) {
        return products.get(id);
    }

/*
    private String id; //상품 ID
    private String name; //상품 명
    private List<PriceRecord> prices;
    private ProductImage productImage; //제품 이미지
    private Date createDate; // 생성 날짜
    private Date updateDate; //수정된 날짜
    private Category category; //상품 카테고리*/

    public static Product put(final long id, final String name,
                              final Category category,
                              final ProductImage productImage,
                              final List<PriceRecord> prices,
                              final Date createDate, final Date updateDate) {
        return products.put(id, new Product(id, name, category, productImage, prices, createDate, updateDate));
    }
}
