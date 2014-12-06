package org.nightschool.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class CartExample {

    private final ArrayList<DiskExample> diskExamples = new ArrayList<>();

    public List<DiskExample> getDiskExamples() {
        return diskExamples;
    }

    public void addDisk(DiskExample diskExample) {
        diskExamples.add(diskExample);
    }

    public int countKinds() {
        HashSet<DiskExample> diskExampleSet = new HashSet<>();

        for (DiskExample diskExample : diskExamples) {
            diskExampleSet.add(diskExample);
        }

        return diskExampleSet.size();
    }

    public void removeDisk(DiskExample diskExample) {
        int count = 0;
        for (DiskExample d : diskExamples) {
            if (d.equals(diskExample)) {
                count++;
            }
        }

        int i=0;
        while (i<count){
            diskExamples.remove(diskExample);
            i++;
        }
    }
}
