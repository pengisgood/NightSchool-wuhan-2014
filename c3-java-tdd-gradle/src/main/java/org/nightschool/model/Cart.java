package org.nightschool.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private final ArrayList<Disk> disks = new ArrayList<>();

    public List<Disk> getDisks() {
        return disks;
    }

    public void addDisk(Disk disk) {
        disks.add(disk);
    }

    public int countKinds() {
        return 0;
    }
}
