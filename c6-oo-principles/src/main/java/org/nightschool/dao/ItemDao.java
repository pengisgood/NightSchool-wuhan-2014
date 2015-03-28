package org.nightschool.dao;

import org.apache.ibatis.session.SqlSession;
import org.nightschool.mybatis.MybatisUtil;
import org.nightschool.dao.mapper.DiskMapper;
import org.nightschool.model.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thoughtworks on 12/26/14.
 */
public class ItemDao {
    ArrayList<Item> items = new ArrayList<Item>();
    SqlSession session = null;
    DiskMapper diskMapper = null;

    public ItemDao() {}

    public List<Item> listDisks() {
        initSession();
        List<Item> result = new ArrayList<Item>();
        try {
            result = diskMapper.getDisks();
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        } finally {
            closeSession();
        }
        return result;
    }

    public void add(Item item) {
        initSession();
        try{
            diskMapper = session.getMapper(DiskMapper.class);
            diskMapper.add(item);
            session.commit();
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        } finally {
            closeSession();
        }
    }

    public Item getByName(String name) {
        Item result = null;
        initSession();
        try{
            result = diskMapper.getByName(name);
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        } finally {
            closeSession();
        }
        return result;
    }

    public void remove(int index) {
        initSession();
        try{
            items.remove(index);
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        } finally {
            closeSession();
        }
    }

    private void initSession() {
        try {
            session = MybatisUtil.getFactory().openSession(true);
            diskMapper = session.getMapper(DiskMapper.class);
        } catch (IOException e) {
            //
        }
    }

    private void closeSession() {
        if(null != session) {
            session.close();
        }
    }
}
