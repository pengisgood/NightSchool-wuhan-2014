package org.nightschool.service;

import org.nightschool.model.Disk;

import java.util.ArrayList;
import java.util.List;

public class CartService {

    private final List<Disk> disks = new ArrayList<>();

    public List<Disk> getDisks() {
        return disks;
    }

    public void addDisk(Disk disk) {
        disks.add(disk);
    }
}
