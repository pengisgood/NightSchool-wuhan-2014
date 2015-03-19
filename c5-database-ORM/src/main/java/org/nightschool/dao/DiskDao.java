package org.nightschool.dao;

import org.nightschool.model.Disk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thoughtworks on 12/26/14.
 */
public class DiskDao {
    ArrayList<Disk> disks = new ArrayList<>();

    public DiskDao() {
        disks.add(new Disk("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张", 0, 3.5));
        disks.add(new Disk("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张", 0, 5.0));
        disks.add(new Disk("1TB大容量光盘", "../images/disk/1TB-disk.jpg", "解放你的硬盘  100元/10张", 0, 10.0));
    }

    public List<Disk> listDisks() {
        return disks;
    }

    public void add(Disk disk) {
        disks.add(disk);
    }

    public void remove(int index) {
        disks.remove(index);
    }
}
