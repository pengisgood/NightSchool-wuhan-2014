package org.nightschool.controller;

import mybatis.TestUtil;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nightschool.dao.mapper.ForTestsMapper;
import org.nightschool.model.Disk;
import org.nightschool.mybatis.MybatisUtil;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Thoughtworks on 12/20/14.
 */
public class DiskControllerTest {
    private static DiskController diskController;

    @BeforeClass
    public static void start() throws Exception {
        MybatisUtil.getFactory(ForTestsMapper.CONFIG_PATH);
        diskController = new DiskController();
        TestUtil.clearItem();
        prepareDisks();
    }

    @Test
    public void test_list_disks_is_empty() throws Exception{
        List<Disk> disks = diskController.list();
        assertThat(disks.size(), is(4));
    }

    @Test
    public void test_list_disks_is_not_empty() throws Exception {
        Disk disk = new Disk("test_name", "USB", "imgUrl", "desc", 1000, 10.0);
        diskController.add(disk);
        assertThat(diskController.list().size(), is(5));
    }

    public static void prepareDisks() {
        List<Disk> disks = new ArrayList<Disk>();
        disks.add(new Disk("小清新光盘", "DISK", "imgUrl", "desc", 1000, 3.5));
        disks.add(new Disk("婚礼专用光盘", "DISK", "imgUrl", "desc", 1000, 5.0));
        disks.add(new Disk("1TB超大容量光盘", "DISK", "imgUrl", "desc", 1000, 10.0));
        disks.add(new Disk("Kingston USB", "USB", "imgUrl", "desc", 1000, 10.0));
        TestUtil.addDisks(disks);
    }
}
