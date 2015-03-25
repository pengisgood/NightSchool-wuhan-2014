package integration;

import org.junit.Test;
import org.nightschool.dao.JDBCService;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class JDBCServiceIntegrationTest
{

    @Test
    public void shouldGetDataFromDatabase() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException
    {

        JDBCService jdbcService = new JDBCService();

        ResultSet results = jdbcService.select("select * from item");

        results.next();

        assertThat(results.getString("name"), is("小清新光盘"));
    }
}
