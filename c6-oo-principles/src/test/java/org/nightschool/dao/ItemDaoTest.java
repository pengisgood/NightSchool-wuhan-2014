package org.nightschool.dao;

import mybatis.TestUtil;
import org.junit.Before;
import org.nightschool.dao.mapper.ForTestsMapper;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nightschool.model.Item;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by luchen on 3/28/15.
 */
public class ItemDaoTest {
    private static ItemDao itemDao;

    @BeforeClass
    public static void start() {
        try {
            MybatisUtil.getFactory(ForTestsMapper.CONFIG_PATH);
            itemDao = new ItemDao();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        TestUtil.clearItem();
    }

    @Test
    public void testAdd() {
        Item expected = createItem();
        TestUtil.addDisks(expected);
        Item actual = itemDao.getByName("Kingston");
        assertEquals(actual, expected);
        assertThat(actual.getId() > 0).isEqualTo(true);
    }

    private Item createItem() {
        return new Item("Kingston", "USB", "../imgUrl/test.jpb", "8gb USB", 100, 100.00);
    }
}
