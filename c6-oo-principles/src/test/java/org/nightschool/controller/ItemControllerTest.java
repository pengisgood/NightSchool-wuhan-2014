package org.nightschool.controller;

import mybatis.TestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nightschool.dao.mapper.ForTestsMapper;
import org.nightschool.model.Item;
import org.nightschool.mybatis.MybatisUtil;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Thoughtworks on 12/20/14.
 */
public class ItemControllerTest {
    private static ItemController itemController;

    @BeforeClass
    public static void start() throws Exception {
        MybatisUtil.getFactory(ForTestsMapper.CONFIG_PATH);
        itemController = new ItemController();
    }

    @Before
    public void setUp() {
        TestUtil.clearItem();
        prepareDisks();
    }


    @Test
    public void test_list_disks_is_empty() throws Exception{
        List<Item> items = itemController.list();
        assertThat(items.size(), is(4));
    }

    @Test
    public void test_list_disks_is_not_empty() throws Exception {
        Item item = new Item("test_name", "USB", "imgUrl", "desc", 1000, 10.0);
        itemController.add(item);
        assertThat(itemController.list().size(), is(5));
    }

    public static void prepareDisks() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("小清新光盘", "DISK", "imgUrl", "desc", 1000, 3.5));
        items.add(new Item("婚礼专用光盘", "DISK", "imgUrl", "desc", 1000, 5.0));
        items.add(new Item("1TB超大容量光盘", "DISK", "imgUrl", "desc", 1000, 10.0));
        items.add(new Item("Kingston USB", "USB", "imgUrl", "desc", 1000, 10.0));
        TestUtil.addDisks(items);
    }
}
