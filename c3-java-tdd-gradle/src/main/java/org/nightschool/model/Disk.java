package org.nightschool.model;

public class Disk {
    private String name;
    private String imgUrl;
    private String desc;

    public Disk(String name, String imgUrl, String desc) {

        this.name = name;
        this.imgUrl = imgUrl;
        this.desc = desc;
    }

    public Disk() {

    }

    public String getName() {
        return name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getDesc() {
        return desc;
    }
}
