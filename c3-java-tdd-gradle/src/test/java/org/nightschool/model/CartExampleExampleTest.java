package org.nightschool.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CartExampleExampleTest {

    private CartExample cartExample;

    @Before
    public void setUp() throws Exception {
        cartExample = new CartExample();
    }

    @Test
    public void should_be_empty_when_no_disk_added() throws Exception {

        List<DiskExample> diskExamples = cartExample.getDiskExamples();

        assertThat(diskExamples.size(), is(0));
    }

    @Test
    public void should_able_to_add_disk_to_cart() throws Exception {
        DiskExample diskExample = new DiskExample();

        cartExample.addDisk(diskExample);

        assertThat(cartExample.getDiskExamples().size(), is(1));
    }

    @Test
    public void should_be_able_to_get_disk_properties() throws Exception {
        DiskExample diskExample = new DiskExample("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");

        cartExample.addDisk(diskExample);
        DiskExample diskExample1 = cartExample.getDiskExamples().get(0);

        assertThat(diskExample1.getName(), is("小清新光盘"));
        assertThat(diskExample1.getImgUrl(), is("../images/disk/fancy-disk.jpg"));
        assertThat(diskExample1.getDesc(), is("小清新、小文艺 35元/10张"));
    }

    @Test
    public void should_be_able_to_count_kinks_of_disks() throws Exception {
        DiskExample fancyDiskExample = new DiskExample("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");
        DiskExample marriageDiskExample = new DiskExample("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张");

        cartExample.addDisk(fancyDiskExample);
        cartExample.addDisk(fancyDiskExample);
        cartExample.addDisk(marriageDiskExample);
        cartExample.addDisk(marriageDiskExample);

        assertThat(cartExample.countKinds(), is(2));
    }

    @Test
    public void should_be_able_to_remove_disk_from_cart() throws Exception {
        DiskExample fancyDiskExample = new DiskExample("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张");
        DiskExample marriageDiskExample = new DiskExample("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张");

        cartExample.addDisk(fancyDiskExample);
        cartExample.addDisk(fancyDiskExample);
        cartExample.addDisk(marriageDiskExample);
        cartExample.removeDisk(fancyDiskExample);

        assertThat(cartExample.getDiskExamples().size(), is(1));

    }
}
