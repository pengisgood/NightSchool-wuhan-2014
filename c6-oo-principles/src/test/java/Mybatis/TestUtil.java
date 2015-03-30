package mybatis;

import org.nightschool.dao.mapper.ForTestsMapper;
import org.apache.ibatis.session.SqlSession;
import org.nightschool.model.CartItem;
import org.nightschool.model.Item;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by luchen on 3/28/15.
 */
public class TestUtil {
    private static SqlSession session;
    private static ForTestsMapper mapper;


    public static void clearItem() {
        try {
            initSessoin();
            mapper.clearItem();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        } finally {
            session.close();
        }

    }

    private static void initSessoin() throws IOException {
        session = MybatisUtil.getFactory().openSession(true);
        mapper = session.getMapper(ForTestsMapper.class);
    }

    public static void addDisks(Object item) {
        try {
            initSessoin();
            if(item instanceof List) {
                List<Item> items = (List<Item>)item;
                for(Item disk : items){
                    mapper.addDisk(disk);
                }
            } else {
                mapper.addDisk((Item)item);
            }
        } catch (IOException e) {
            System.out.println(e.getCause());
            session.rollback();
        } finally {
            session.close();
        }
    }

    public static CartItem getCartItemByItemId(int itemid) {
        CartItem cartItem = null;
        try {
            initSessoin();
            cartItem = mapper.getCartItemId(itemid);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return cartItem;
    }

    public static void clearCartItem() {
        try {
            initSessoin();
            mapper.clearCartItem();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
