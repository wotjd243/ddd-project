package io.github.wotjd243.ecommerce.Item.domain;

import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.assertj.core.api.Assertions.assertThat;


public class ItemTest {

    @Test
    public void 아이템_생성() throws MalformedURLException {
        String title = "Harry Potter";
        URL url = new URL("http://thumbs1.ebaystatic.com/m/m80hGwQEYVi2QUduAtjeVhw/140.jpg");
        double price = 25.45;
        String sellingState = "Active";

        Item item = new Item(title, price, url.toString(), sellingState);

        assertThat(item).isNotNull();
    }
}