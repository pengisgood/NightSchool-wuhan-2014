package org.nightschool.dao;

import org.apache.ibatis.session.SqlSession;
import org.nightschool.mybatis.MybatisUtil;
import org.nightschool.dao.mapper.DiskMapper;
import org.nightschool.model.Disk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thoughtworks on 12/26/14.
 */
public class DiskDao {
    ArrayList<Disk> disks = new ArrayList<Disk>();
    SqlSession session = null;
    DiskMapper diskMapper = null;

    public DiskDao() {}

    public List<Disk> listDisks() {
        initSession();
        List<Disk> result = new ArrayList<Disk>();
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

    public void add(Disk disk) {
        initSession();
        try{
            diskMapper = session.getMapper(DiskMapper.class);
            diskMapper.add(disk);
            session.commit();
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        } finally {
            closeSession();
        }
    }

    public Disk getByName(String name) {
        Disk result = null;
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
            disks.remove(index);
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
