package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nightschool.mybatis.MybatisUtil;
import org.nightschool.dao.mapper.ClearTableMapper;

import java.io.IOException;

public class ClearTables {

    private static SqlSession session;
    private static ClearTableMapper mapper;

    @BeforeClass
    public static void init() {
        try {
            session = MybatisUtil.getFactory("mybatis/testConfig.xml").openSession();
            mapper =  session.getMapper(ClearTableMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void end() {
        if(session != null) {
            session.close();
        }
    }

    @Test
    public void revertDatabase() throws IOException {
        dropCartItem(mapper);
        dropItem(mapper);
        dropItemSequence(mapper);
        clearChangeLog(mapper);
        clearChangeLogLock(mapper);
    }

    private void dropItemSequence(ClearTableMapper mapper) {
        try {
            mapper.dropItemSequence();
        }catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
    }

    private void dropItem(ClearTableMapper mapper) {
        try {
            mapper.dropItem();
        }catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
    }

    private void dropCartItem(ClearTableMapper mapper) {
        try {
            mapper.dropCartItem();
        }catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
    }

    private void clearChangeLog(ClearTableMapper mapper) {
        try {
            mapper.clearChangeLog();
        }catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
    }

    private void clearChangeLogLock(ClearTableMapper mapper) {
        try {
            mapper.clearChangeLogLock();
        }catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
    }

}
