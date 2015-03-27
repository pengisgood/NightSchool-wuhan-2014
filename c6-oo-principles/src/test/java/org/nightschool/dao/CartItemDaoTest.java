package org.nightschool.dao;

import org.apache.ibatis.session.SqlSession;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nightschool.dao.mapper.CartItemMapper;
import org.nightschool.dao.mapper.ClearTableMapper;
import org.nightschool.model.Cart;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by luchen on 3/27/15.
 */
public class CartItemDaoTest {

    private static SqlSession session;
    private static CartItemMapper mapper;
    @BeforeClass
    public static void init() throws IOException {
        session = MybatisUtil.getFactory("mybatis/testConfig.xml").openSession();
        mapper = session.getMapper(CartItemMapper.class);
    }

    @AfterClass
    public static void releaseResources() throws IOException {
        session.getMapper(ClearTableMapper.class).dropCartItem();
        session.close();
    }

    @Test
    public void testAddCartItem() {
        Cart.CartItem cartItem = new Cart.CartItem();
        cartItem.setItemid(1);
        cartItem.setNumber(10);
        try {
            mapper.add(cartItem);
            assertThat(mapper.getCount(1)).isEqualTo(1);
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }
}
