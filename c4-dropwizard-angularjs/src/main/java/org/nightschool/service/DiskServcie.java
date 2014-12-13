package org.nightschool.service;

import org.nightschool.model.Disk;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by twer on 12/14/14.
 */
public class DiskServcie {

    private final List disks = new ArrayList();

    public List<Disk> listDisks() {
        return disks;
    }

    public void add(Disk disk) {
        disks.add(disk);
    }
}
