package io.github.wotjd243.ecommerce.product.domain;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;
import io.github.wotjd243.ecommerce.product.domain.Item.SellingState;

public class ItemTest {

    @Test
    public void 아이템_생성() throws MalformedURLException {
        Item item = createItem();

        assertThat(item).isNotNull();
        assertThat(item.isActive()).isTrue();
    }

    public static Item createItem() throws MalformedURLException {
        String title = "Harry Potter";
        URL url = new URL("http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg");
        double price = 25.45;
        SellingState sellingState = SellingState.ACTIVE;

        return new Item(title, price, url, sellingState);
    }
}