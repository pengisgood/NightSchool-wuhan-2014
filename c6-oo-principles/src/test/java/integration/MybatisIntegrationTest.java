package integration;

import org.junit.Test;
import org.nightschool.mybatis.MybatisUtil;
import org.nightschool.dao.mapper.DiskMapper;
import org.nightschool.model.Disk;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertNotNull;

public class MybatisIntegrationTest
{
    @Test
    public void shouldGetDisks() throws IOException
    {
        DiskMapper mapper = MybatisUtil.getFactory().openSession().getMapper(DiskMapper.class);
        List<Disk> disks = mapper.getDisks();

        assertThat(disks.size(), is(46));
    }


    @Test
    public void shouldInsertDisk() throws IOException
    {
        DiskMapper mapper = MybatisUtil.getFactory().openSession().getMapper(DiskMapper.class);
        List<Disk> disks = mapper.getDisks();

        assertThat(disks.size(), is(46));

        mapper.add(new Disk("小苹果", "test", "test", 1, 10.0));
        disks = mapper.getDisks();

        assertThat(disks.size(), is(47));
    }
}
