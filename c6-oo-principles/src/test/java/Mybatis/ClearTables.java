package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.nightschool.mybatis.MybatisUtil;
import org.nightschool.dao.mapper.ClearTableMapper;

import java.io.IOException;

public class ClearTables {

    @Test
    public void clearTables() throws IOException {
        SqlSession session = MybatisUtil.getFactory("mybatis/testConfig.xml").openSession();
        ClearTableMapper mapper =  session.getMapper(ClearTableMapper.class);
        mapper.clearItem();
        mapper.clearChangeLog();
        mapper.clearChangelogLock();
        session.commit();
        session.close();
    }

}
