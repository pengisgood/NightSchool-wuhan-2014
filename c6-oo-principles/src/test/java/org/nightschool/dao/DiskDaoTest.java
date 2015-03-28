package org.nightschool.dao;

import mybatis.TestUtil;
import org.nightschool.dao.mapper.ForTestsMapper;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nightschool.model.Disk;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Created by luchen on 3/28/15.
 */
public class DiskDaoTest {
    private static DiskDao diskDao;

    @BeforeClass
    public static void start() {
        try {
            MybatisUtil.getFactory(ForTestsMapper.CONFIG_PATH);
            diskDao = new DiskDao();
            TestUtil.clearItem();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void end() {
        diskDao.closeSession();
    }

    @Test
    public void testAdd() {
        Disk expected = createDisk();
        TestUtil.addDisks(expected);
        assertEquals(diskDao.getByName("Kingston"), expected);
    }

    private Disk createDisk() {
        return new Disk("Kingston", "USB", "../imgUrl/test.jpb", "8gb USB", 100, 100.00);
    }
}
