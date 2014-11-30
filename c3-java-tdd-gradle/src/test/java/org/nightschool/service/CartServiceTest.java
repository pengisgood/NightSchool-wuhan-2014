package org.nightschool.service;

import org.junit.Test;
import org.nightschool.model.Disk;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CartServiceTest {
    @Test
    public void should_cart_be_empty_when_nothing_added() throws Exception {
        CartService cartService = new CartService();

        List<Disk> disks = cartService.getDisks();

        assertThat(disks.size(), is(0));
    }
}
