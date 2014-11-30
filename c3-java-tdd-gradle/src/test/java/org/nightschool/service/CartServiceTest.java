package org.nightschool.service;

import org.junit.Before;
import org.junit.Test;
import org.nightschool.model.Disk;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class CartServiceTest {

    private CartService cartService;

    @Before
    public void setUp() throws Exception {
        cartService = new CartService();
    }

    @Test
    public void should_cart_be_empty_when_nothing_added() throws Exception {
        List<Disk> disks = cartService.getDisks();

        assertThat(disks.size(), is(0));
    }

    @Test
    public void should_able_to_add_disk_to_cart() throws Exception {
        Disk disk = new Disk("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");

        cartService.addDisk(disk);
        List<Disk> disks= cartService.getDisks();

        assertThat(disks.size(), is(1));
        assertThat(disks.get(0), equalTo(disk));
    }
}
