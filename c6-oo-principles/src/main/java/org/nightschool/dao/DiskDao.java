package org.nightschool.dao;

import org.apache.ibatis.session.SqlSession;
import org.nightschool.Mybatis.MybatisUtil;
import org.nightschool.mapper.DiskMapper;
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
//        disks.add(new Disk("XQX", "../images/disk/fancy-disk.jpg", "你好", 0, 3.5));
//        disks.add(new Disk("Wedding", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张", 0, 5.0));
//        disks.add(new Disk("1TB Big Storage", "../images/disk/1TB-disk.jpg", "解放你的硬盘  100元/10张", 0, 10.0));
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
        DiskMapper diskMapper = session.getMapper(DiskMapper.class);
        return diskMapper.getDisks();
    }

    public void add(Disk disk) {
        disks.add(disk);
    }

    public void remove(int index) {
        disks.remove(index);
    }
}
