package io.github.wotjd243.ecommerce.Item.domain;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {

    @Test
    public void 아이템_생성() {

        new Item("Harry Potter",25.45,
                "http:\\/\\/thumbs1.ebaystatic.com\\/m\\/m80hGwQEYVi2QUduAtjeVhw\\/140.jpg", "Active");
    }
}