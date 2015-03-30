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

    @Test
    public void testAddTheSame() {
        CartItem cartItem1 = new CartItem(1, 10);
        CartItem cartItem2 = new CartItem(1, 10);
        cartItemDao.add(cartItem1);
        cartItemDao.add(cartItem2);
        assertThat(TestUtil.getCartItemByItemId(1)).isEqualTo(new CartItem(1, 20));
    }

    @Test
    public void testAll() {
        CartItem cartItem1 = new CartItem(1, 10);
        CartItem cartItem2 = new CartItem(2, 10);
        CartItem cartItem3 = new CartItem(3, 10);
        cartItemDao.add(cartItem1);
        cartItemDao.add(cartItem2);
        cartItemDao.add(cartItem3);
        assertThat(cartItemDao.all().size()).isEqualTo(3);
    }

}
