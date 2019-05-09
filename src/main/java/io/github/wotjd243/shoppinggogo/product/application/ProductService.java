package io.github.wotjd243.shoppinggogo.product.application;

import io.github.wotjd243.shoppinggogo.product.domain.Category;
import io.github.wotjd243.shoppinggogo.product.domain.PriceRecord;
import io.github.wotjd243.shoppinggogo.product.domain.Product;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.NoSuchElementException;

@Service
public class ProductService {


    /**
     * @todo 추후, 구현
     *
     * 카테고리에 의해, 제품들을 조회한다.
     * @param category 카테고리
     */
    public void findProductsByCategory(Category category) {

    }

    /**
     * @todo 추후, 구현
     *
     * 특정 상품 키워드 검색 시, 타 사용자가 구매한 제품들을 추천목록으로 나타낸다.
     * @param category 카테고리
     */
    public void findRecommendProducts(Category category) {

    }


    /**
     * 제품 가장 낮은 가격을 조회한다.
     * @return
     */
    public Integer findLowestPriceByProduct(Product product) {
        return product.findLowestPrice();
    }


}
