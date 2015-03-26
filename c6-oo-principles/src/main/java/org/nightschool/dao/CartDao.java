package org.nightschool.dao;

import org.apache.ibatis.session.SqlSession;
import org.nightschool.model.Disk;
import org.nightschool.mybatis.MybatisUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thoughtworks on 12/26/14.
 */
public class CartDao {
    private final ArrayList<Disk> cart = new ArrayList<Disk>();

    private SqlSession getSession() {
        SqlSession session = null;
        try {
            session = MybatisUtil.getFactory().openSession();
        } catch (IOException e) {
            //
        }
        return session;
    }

    public void add(Disk disk) {
        for(int i = 0; i < cart.size(); i++)
        {
            if(cart.get(i).getName().equals(disk.getName())) {
                break;
            }
        }

        if(i == cart.size()) {
            cart.add(disk);
        }
        else {
            cart.get(i).setNumber(cart.get(i).getNumber() + disk.getNumber());
        }
    }

    public List<Disk> cartList() {
        return cart;
    }
}
