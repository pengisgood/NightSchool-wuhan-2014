package org.nightschool.controller;

import org.junit.Test;
import org.nightschool.model.Disk;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Thoughtworks on 12/20/14.
 */
public class DiskControllerTest {
    private  final DiskController diskController = new DiskController();
    @Test
    public void test_list_disks_is_empty() throws Exception{
        List<Disk> disks = diskController.list();
        assertThat(disks.size(), is(3));
    }

    @Test
    public void test_list_disks_is_not_empty() throws Exception {
        Disk disk = new Disk();
        diskController.add(disk);

        assertThat(diskController.list().size(), is(4));
    }
}
