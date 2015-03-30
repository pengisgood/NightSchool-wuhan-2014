package org.nightschool.dao;

import org.apache.ibatis.session.SqlSession;
import org.nightschool.dao.mapper.CartItemMapper;
import org.nightschool.model.CartItem;
import org.nightschool.model.Item;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;
import java.util.List;

/**
 * Created by luchen on 3/28/15.
 */
public class CartItemDao {
    SqlSession session = null;
    CartItemMapper cartItemMapper = null;

    public void add(CartItem cartItem) {
        initSession();
        CartItem existCartItem = cartItemMapper.queryByKey(cartItem.getUsername(), cartItem.getItemid());
        if(existCartItem != null) {
            cartItem.setNumber(cartItem.getNumber() + existCartItem.getNumber());
            cartItemMapper.update(cartItem);
        }
        else {
            cartItemMapper.add(cartItem);
            if (session != null) {
                session.close();
            }
        }
    }

    public CartItem query(String username, int itemid) {
        initSession();
        try {
            return cartItemMapper.queryByKey(username, itemid);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<CartItem> all() {
        initSession();
        try {
            return cartItemMapper.all();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    private void initSession(){
        try {
            session = MybatisUtil.getFactory().openSession(true);
            cartItemMapper = session.getMapper(CartItemMapper.class);
        } catch (IOException e) {
            //TODO should record Exception to log
            e.printStackTrace();
        }
    }

}
