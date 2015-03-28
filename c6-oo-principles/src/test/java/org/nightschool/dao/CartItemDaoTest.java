package org.nightschool.dao;

import mybatis.TestUtil;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.nightschool.dao.mapper.ForTestsMapper;
import org.nightschool.model.CartItem;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by luchen on 3/28/15.
 */
public class CartItemDaoTest {
    private static CartItemDao cartItemDao;

    @BeforeClass
    public static void start() {
        try {
            MybatisUtil.getFactory(ForTestsMapper.CONFIG_PATH);
            cartItemDao = new CartItemDao();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Before
    public void setUp() {
        TestUtil.clearCartItem();
    }

    @Test
    public void testAdd() {
        CartItem cartItem = new CartItem(1, 10);
        cartItemDao.add(cartItem);
        assertThat(TestUtil.getCartItemByItemId(1)).isEqualTo(cartItem);
    }

}
