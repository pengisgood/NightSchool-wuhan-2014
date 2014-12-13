package org.nightschool.service;

import org.junit.Before;
import org.junit.Test;
import org.nightschool.model.Disk;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by twer on 12/14/14.
 */
public class ServiceTest {

    private DiskServcie diskServcie;

    @Before
    public void setUp() throws Exception {
        diskServcie = new DiskServcie();
    }

    @Test
    public void test_list_disks_is_empty() throws Exception {
        List<Disk> disks = diskServcie.listDisks();
        assertThat(disks.size(), is(0));
    }

    @Test
    public void test_list_disk_is_non_empty_after_add_a_disk() throws Exception {
        Disk disk = new Disk("diskname", "diksimage", "diskdesc");
        diskServcie.add(disk);
        assertThat(diskServcie.listDisks().size(), is(1));
    }
}
