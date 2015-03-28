package mybatis;

import org.nightschool.dao.mapper.ForTestsMapper;
import org.apache.ibatis.session.SqlSession;
import org.nightschool.model.Disk;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by luchen on 3/28/15.
 */
public class TestUtil {

    public static void clearItem() {
        SqlSession session = null;
        try {
            session = MybatisUtil.getFactory().openSession(true);
            ForTestsMapper mapper = session.getMapper(ForTestsMapper.class);
            mapper.clearItem();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }

    }

    public static void addDisks(Object item) {
        SqlSession session = null;
        try {
            session = MybatisUtil.getFactory().openSession(true);
            ForTestsMapper mapper = session.getMapper(ForTestsMapper.class);
            if(item instanceof List) {
                List<Disk> items = (List<Disk>)item;
                for(Disk disk : items){
                    mapper.addDisk(disk);
                }
            } else {
                mapper.addDisk((Disk)item);
            }
        } catch (IOException e) {
            System.out.println(e.getCause());
            session.rollback();
        } finally {
            session.close();
        }
    }

}
