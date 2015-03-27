package org.nightschool.dao;

import org.apache.ibatis.session.SqlSession;
import org.nightschool.dao.mapper.CartItemMapper;
import org.nightschool.model.Cart.CartItem;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by Thoughtworks on 12/26/14.
 */
public class CartItemDao {

    private SqlSession getSession() {
        SqlSession session = null;
        try {
            session = MybatisUtil.getFactory().openSession();
        } catch (IOException e) {
            //
        }
        return session;
    }

    public void add(CartItem cartItem) {
        SqlSession session = getSession();
        try {
            CartItemMapper mapper = getSession().getMapper(CartItemMapper.class);
            mapper.add(cartItem);
        } finally {
            session.close();
        }
    }

    public List<CartItem> cartList() {
        SqlSession session = getSession();
        try {
            CartItemMapper mapper = getSession().getMapper(CartItemMapper.class);
            return mapper.getCartItems();
        } finally {
            session.close();
        }
    }

}
