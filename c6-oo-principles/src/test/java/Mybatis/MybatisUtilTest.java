package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by luchen on 3/24/15.
 */
public class MybatisUtilTest {

    @Test
    public void should_connect_to_database() throws IOException {
        SqlSessionFactory factory = MybatisUtil.getFactory();
        SqlSession session = factory.openSession();
        Connection conn = session.getConnection();
        assertThat(session.getConnection()).isNotNull();
        closeResources(session, conn);
    }

    private void closeResources(SqlSession session, Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
            if (session != null) {
                session.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
