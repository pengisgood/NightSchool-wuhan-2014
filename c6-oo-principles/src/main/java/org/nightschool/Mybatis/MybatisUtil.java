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

    private static String CONFIG_PATH = "mybatis/config.xml";

    public static SqlSessionFactory getFactory() throws IOException
    {
        return getFactory(null);
    }

    public static SqlSessionFactory getFactory(String configPath) throws IOException
    {
        if (sqlSessionFactory == null) {
            if(StringUtils.isBlank(configPath)) {
                configPath = CONFIG_PATH;
            }
            System.out.println("=================load config from :" + configPath);
            InputStream inputStream = Resources.getResourceAsStream(configPath);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }
        return sqlSessionFactory;
    }

}
