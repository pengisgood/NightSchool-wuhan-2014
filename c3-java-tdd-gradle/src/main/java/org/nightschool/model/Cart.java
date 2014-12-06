package org.nightschool.model;

import java.util.ArrayList;
import java.util.HashSet;
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
        HashSet<Disk> diskSet = new HashSet<>();

        for (Disk disk : disks) {
            diskSet.add(disk);
        }

        return diskSet.size();
    }
}
