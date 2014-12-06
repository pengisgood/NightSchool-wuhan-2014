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

    public void removeDisk(Disk disk) {
        int count = 0;
        for (Disk d : disks) {
            if (d.equals(disk)) {
                count++;
            }
        }

        int i=0;
        while (i<count){
            disks.remove(disk);
            i++;
        }
    }
}
