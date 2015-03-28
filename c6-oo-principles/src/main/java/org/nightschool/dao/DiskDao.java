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

    public DiskDao() {
        initSession();
    }

    public List<Disk> listDisks() {
        List<Disk> result = new ArrayList<Disk>();
        try {
            DiskMapper diskMapper = session.getMapper(DiskMapper.class);
            result = diskMapper.getDisks();
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
        return result;
    }

    public void add(Disk disk) {
        try{
            DiskMapper diskMapper = session.getMapper(DiskMapper.class);
            diskMapper.add(disk);
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
    }

    private void initSession() {
        try {
            session = MybatisUtil.getFactory().openSession();
        } catch (IOException e) {
            //
        }
    }

    public Disk getByName(String name) {
        Disk result = null;
        try{
            DiskMapper diskMapper = session.getMapper(DiskMapper.class);
            result = diskMapper.getByName(name);
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
        return result;
    }

    public void remove(int index) {
        try{
            disks.remove(index);
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
    }

    public void closeSession() {
        session.close();
    }
}
