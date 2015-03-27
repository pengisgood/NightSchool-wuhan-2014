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

    private void initSession() {
        try {
            session = MybatisUtil.getFactory().openSession();
        } catch (IOException e) {
            //
        }
    }

    public List<Disk> listDisks() {
        List<Disk> result = new ArrayList<Disk>();
        try {
            DiskMapper diskMapper = session.getMapper(DiskMapper.class);
            result = diskMapper.getDisks();
        } catch (Exception e) {
            session.rollback();
        }
        return result;
    }

    public void add(Disk disk) {
        try{
            System.out.println("========================== " + disk.toString());
            DiskMapper diskMapper = session.getMapper(DiskMapper.class);
            diskMapper.add(disk);
        } catch (Exception e) {
            System.out.println(e);
            session.rollback();
        }
    }

    public void remove(int index) {
        try{
            disks.remove(index);
        } catch (Exception e) {
            session.rollback();
        }
    }
}
