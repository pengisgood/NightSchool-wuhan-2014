package mybatis;

import org.nightschool.dao.mapper.ForTestsMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;

public class RevertDatabase {

    private static SqlSession session;
    private static ForTestsMapper mapper;

    @BeforeClass
    public static void init() {
        try {
//            session = MybatisUtil.getFactory(ForTestsMapper.CONFIG_PATH).openSession(true);
            session = MybatisUtil.getFactory().openSession(true);
            mapper =  session.getMapper(ForTestsMapper.class);
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
        dropCartItem();
        dropItem();
        clearChangeLog();
        clearChangeLogLock();
    }

    private void dropItem() {
        try {
            mapper.dropItem();
        }catch (Exception e) {
            session.rollback();
            System.out.println(e);
        }
    }

    private void dropCartItem() {
        try {
            mapper.dropCartItem();
        }catch (Exception e) {
            session.rollback();
            System.out.println(e);
        }
    }

    private void clearChangeLog() {
        try {
            mapper.clearChangeLog();
        }catch (Exception e) {
            session.rollback();
            System.out.println(e);
        }
    }

    private void clearChangeLogLock() {
        try {
            mapper.clearChangeLogLock();
        }catch (Exception e) {
            session.rollback();
            System.out.println(e);
        }
    }

}
