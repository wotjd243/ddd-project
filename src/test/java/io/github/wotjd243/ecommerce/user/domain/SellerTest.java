package io.github.wotjd243.ecommerce.user.domain;

import io.github.wotjd243.ecommerce.product.domain.Item;
import io.github.wotjd243.ecommerce.product.domain.Product;
import org.junit.Test;

import java.net.MalformedURLException;
import java.util.List;

import static io.github.wotjd243.ecommerce.product.domain.ItemTest.createItem;
import static org.assertj.core.api.Assertions.assertThat;

public class SellerTest {
    private final static String TEST_USER_ID = "TEST_USER";
    private final static String TEST_PRODUCT_NAME = "TEST_PRODUCT";

    Seller seller = new Seller(TEST_USER_ID);
    Product product = new Product(TEST_PRODUCT_NAME);

    @Test
    public void 판매자가_물품을_등록() throws MalformedURLException {
        Item item = createItem();
        seller.registerGoods(product, item);

        List<Item> items = seller.retrieve(product);
        assertThat(items.get(0)).isEqualTo(item);
    }
}