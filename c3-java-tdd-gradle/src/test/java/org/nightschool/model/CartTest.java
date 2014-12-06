package org.nightschool.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CartTest {

    private Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @Test
    public void should_be_empty_when_no_disk_added() throws Exception {

        List<Disk> disks = cart.getDisks();

        assertThat(disks.size(), is(0));
    }

    @Test
    public void should_able_to_add_disk_to_cart() throws Exception {
        Disk disk = new Disk();

        cart.addDisk(disk);

        assertThat(cart.getDisks().size(), is(1));
    }

    @Test
    public void should_be_able_to_get_disk_properties() throws Exception {
        Disk disk = new Disk("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");

        cart.addDisk(disk);
        Disk disk1 = cart.getDisks().get(0);

        assertThat(disk1.getName(), is("小清新光盘"));
        assertThat(disk1.getImgUrl(), is("../images/disk/fancy-disk.jpg"));
        assertThat(disk1.getDesc(), is("小清新、小文艺 35元/10张"));
    }
}
