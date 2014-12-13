package org.nightschool.model;

public class Disk {
    private String name;
    private String img;
    private String desc;

    public Disk(String name, String img, String desc) {

        this.name = name;
        this.img = img;
        this.desc = desc;
    }

    public Disk() {

    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public String getDesc() {
        return desc;
    }
}
