package org.nightschool.model;

public class DiskExample {
    private String name;
    private String imgUrl;
    private String desc;

    public DiskExample(String name, String imgUrl, String desc) {

        this.name = name;
        this.imgUrl = imgUrl;
        this.desc = desc;
    }

    public DiskExample() {

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
