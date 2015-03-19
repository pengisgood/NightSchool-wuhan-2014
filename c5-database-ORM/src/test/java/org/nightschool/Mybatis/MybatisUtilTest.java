package org.nightschool.Mybatis;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;

public class MybatisUtilTest
{

    @Test
    public void shouldGetSessionFactory() throws IOException
    {
        SqlSessionFactory factory = MybatisUtil.getFactory();

        assertNotNull(factory);
    }

}
