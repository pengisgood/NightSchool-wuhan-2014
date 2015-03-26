package org.nightschool.model;

public class Disk {
    private String name;
    private String imgurl;
    private String description;
    private int count;
    private double price;
    private String category;
    private int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


    public Disk(String name, String imgurl, String description, int count, double price)
    {
        this.name = name;
        this.imgurl = imgurl;
        this.description = description;
        this.count = count;
        this.price = price;
    }

    public Disk() {

    }

    public String getName() {
        return name;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String toString() {
        return name + " : " + category + " : " + imgurl + " : " + description + " : ";
    }
}
