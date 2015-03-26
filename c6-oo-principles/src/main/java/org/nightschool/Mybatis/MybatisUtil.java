package org.nightschool.mybatis;

import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil
{
    private static SqlSessionFactory sqlSessionFactory;

    private static final String DEFAULT_CONFIG_PATH = "mybatis/config.xml";

    public static SqlSessionFactory getFactory() throws IOException
    {
        return MybatisUtil.getFactory(null);
    }

    public static SqlSessionFactory getFactory(String configFile) throws IOException
    {
        configFile = StringUtils.isNotBlank(configFile) ? configFile : DEFAULT_CONFIG_PATH;
        InputStream inputStream = Resources.getResourceAsStream(configFile);
        if (sqlSessionFactory == null) {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }
}
